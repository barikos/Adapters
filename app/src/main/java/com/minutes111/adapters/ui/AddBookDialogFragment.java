package com.minutes111.adapters.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Book;

/**
 * Created by barikos on 27.04.16.
 */
public class AddBookDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText mEditTextName;
    private EditText mEditTextAuth;
    private Button mButtonAdd;
    private Button mButtonDismiss;
    private Button mButtonPicker;

    private String fileManagerString;

    OnBookAddListener mBookAddListener;

    public AddBookDialogFragment() {
    }

    public interface OnBookAddListener {
        void createNewBook(Book book);
    }

    public static AddBookDialogFragment newInstance(String title) {
        AddBookDialogFragment frag = new AddBookDialogFragment();
        Bundle args = new Bundle();
        args.putString(Const.FRAG_TITLE, title);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_add, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditTextName = (EditText) view.findViewById(R.id.edit_add_name);
        mEditTextAuth = (EditText) view.findViewById(R.id.edit_add_auth);
        mButtonAdd = (Button) view.findViewById(R.id.btn_add_add);
        mButtonDismiss = (Button) view.findViewById(R.id.btn_add_dismiss);
        mButtonPicker = (Button) view.findViewById(R.id.btn_add_picker);

        mBookAddListener = (OnBookAddListener) getActivity();

        mButtonAdd.setOnClickListener(this);
        mButtonDismiss.setOnClickListener(this);
        mButtonPicker.setOnClickListener(this);

        String title = getArguments().getString(Const.FRAG_TITLE, "Enter data");
        getDialog().setTitle(title);
        mEditTextName.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_add:
                String name = mEditTextName.getText().toString();
                String auth = mEditTextAuth.getText().toString();
                Book book = new Book().setName(name).setAuthor(auth);
                mBookAddListener.createNewBook(book);
                dismiss();
                break;
            case R.id.btn_add_dismiss:
                dismiss();
                break;
            case R.id.btn_add_picker:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                this.startActivityForResult(Intent.createChooser(intent, "Select picture"), Const.RESULT_CODE_PIKER);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(Const.LOG_TAG, "STSAC");
        Uri selectedImgUri = data.getData();

        fileManagerString = selectedImgUri.getPath();
        Log.d(Const.LOG_TAG, fileManagerString);

        if (requestCode == Activity.RESULT_OK) {
            if (requestCode == Const.RESULT_CODE_PIKER) {

            }
        }
    }
}
