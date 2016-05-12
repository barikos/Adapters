package com.minutes111.adapters.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
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
import android.widget.Toast;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.R;
import com.minutes111.adapters.ui.adapter.RecyclerBookAdapter;
import com.minutes111.adapters.database.DBContact;
import com.minutes111.adapters.database.DBHelper;
import com.minutes111.adapters.util.ModelMapper;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    public static final int ATTR_LAYOUT_LIN = 1;
    public static final int ATTR_LAYOUT_GRID = 2;

    private EditText mEditText;
    private Button mButtonSearch;
    private Button mButtonAdd;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

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
        mButtonAdd = (Button) findViewById(R.id.btn_add_add);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.lay_drawer);
        mNavigationView = (NavigationView)findViewById(R.id.nav_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.rcView_recycler);

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

        mNavigationView.setNavigationItemSelectedListener(getListener());

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerBookAdapter(this, mData, ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            return;
        }
        try {
            ContentValues cv = new ContentValues();
            cv.put(DBContact.KEY_NAME,data.getStringExtra(Const.ATTR_BOOK_NAME));
            cv.put(DBContact.KEY_AUTH,data.getStringExtra(Const.ATTR_BOOK_AUTH));
            cv.put(DBContact.KEY_IMG,data.getByteArrayExtra(Const.ATTR_BOOK_IMG));
            cv.put(DBContact.KEY_RATING,data.getFloatExtra(Const.ATTR_BOOK_RATING,0));
            mDB.insert(DBContact.TABLE_NAME, null, cv);
            Toast.makeText(RecyclerActivity.this, "The book have been added", Toast.LENGTH_SHORT).show();
        }catch (SQLiteException e){

        }

        Cursor cursor = mDB.query(DBContact.TABLE_NAME, null, null, null, null, null, null);
        mData = ModelMapper.getListBookModel(cursor);
        cursor.close();

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

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
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


    private NavigationView.OnNavigationItemSelectedListener getListener(){
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.drawer_menu_item_1){
                    Intent intent = new Intent(RecyclerActivity.this,AddBookActivity.class);
                    startActivityForResult(intent,Const.RESULT_CODE_ADD_BOOK);
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        };
    }
}
