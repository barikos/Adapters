package com.minutes111.adapters.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.R;
import com.minutes111.adapters.ui.adapter.RecyclerBookAdapter;
import com.minutes111.adapters.util.ModelMapper;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    public static final int ATTR_LAYOUT_LIN = 1;
    public static final int ATTR_LAYOUT_GRID = 2;

    private EditText mEditText;
    private Button mButtonSearch;
    private Button mButtonAdd;

    private ArrayList mData;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerBookAdapter mAdapter;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setTitle(R.string.text_activity_recycler_title);

        mEditText = (EditText) findViewById(R.id.edit_search);
        mButtonSearch = (Button) findViewById(R.id.btn_search);
        mButtonAdd = (Button) findViewById(R.id.btn_add);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcView_recycler);
        mRecyclerView.setHasFixedSize(true);

        mDBHelper = new DBHelper(this);
        try {
            mDB = mDBHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            mDB = mDBHelper.getReadableDatabase();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Cursor cursor = mDB.query(DBContact.TABLE_NAME, null, null, null, null, null, null);
        mData = ModelMapper.getListBookModel(cursor);
        cursor.close();

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerBookAdapter(this, mData, ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rec_menu_lin:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new RecyclerBookAdapter(this, mData, ATTR_LAYOUT_LIN);
                break;
            case R.id.rec_menu_grid:
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new RecyclerBookAdapter(this, mData, ATTR_LAYOUT_GRID);
                break;
        }
        mRecyclerView.setAdapter(mAdapter);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDB.close();
    }

    public void onClickSearch(View view){
        String searchFilter = mEditText.getText().toString();
        String selection = String.format("%s like ?", DBContact.KEY_NAME);
        Log.d(Const.LOG_TAG, searchFilter);
        String[] selectionArgs = {searchFilter+"%"};

        Cursor cursor = mDB.query(DBContact.TABLE_NAME, null, selection, selectionArgs, null, null, null);
        mData = ModelMapper.getListBookModel(cursor);
        cursor.close();

        mAdapter = new RecyclerBookAdapter(this, mData, ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void onClickAdd(View view){
        showAddDialog();
    }

    private void showAddDialog(){
        FragmentManager fm = getSupportFragmentManager();
        AddBookDialogFragment dialogFragment = AddBookDialogFragment.newInstance("Some title");
        dialogFragment.show(fm,"fragment_edit");
    }
}
