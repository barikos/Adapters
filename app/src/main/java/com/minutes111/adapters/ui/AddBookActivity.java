package com.minutes111.adapters.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.R;
import com.minutes111.adapters.util.ConvertImage;

import java.io.IOException;
import java.util.Arrays;

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditTextName;
    private EditText mEditTextAuth;
    private Button mButtonAdd;
    private Button mButtonDismiss;
    private Button mButtonPicker;
    private RatingBar mRatingBar;
    private ImageView mImageView;

    private byte[] mImg;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        mEditTextName = (EditText) findViewById(R.id.edit_add_name);
        mEditTextAuth = (EditText) findViewById(R.id.edit_add_auth);
        mButtonAdd = (Button) findViewById(R.id.btn_add_add);
        mButtonDismiss = (Button) findViewById(R.id.btn_add_dismiss);
        mButtonPicker = (Button) findViewById(R.id.btn_add_picker);
        mRatingBar = (RatingBar) findViewById(R.id.rating_add);
        mImageView = (ImageView) findViewById(R.id.img_add_book);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mButtonPicker.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonDismiss.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_picker:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                this.startActivityForResult(Intent.createChooser(intent, "Select picture"), Const.RESULT_CODE_PIKER);
                break;
            case R.id.btn_add_add:
                Intent intentRes = new Intent();
                intentRes.putExtra(Const.ATTR_BOOK_NAME, mEditTextName.getText().toString());
                intentRes.putExtra(Const.ATTR_BOOK_AUTH, mEditTextAuth.getText().toString());
                intentRes.putExtra(Const.ATTR_BOOK_IMG, mImg);
                intentRes.putExtra(Const.ATTR_BOOK_RATING, mRatingBar.getRating());
                setResult(RESULT_OK, intentRes);
                finish();
                break;
            case R.id.btn_add_dismiss:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            mBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
            mImg = ConvertImage.getBytesImage(mBitmap);
            mImageView.setImageBitmap(mBitmap);
            Log.d(Const.LOG_TAG, Arrays.toString(mImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
