package com.minutes111.adapters.ui.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Book;
import com.minutes111.adapters.ui.adapter.RecyclerBookAdapter;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    public static final int ATTR_LAYOUT_LIN = 1;
    public static final int ATTR_LAYOUT_GRID = 2;

    private ArrayList mData;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerBookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        setTitle(R.string.text_activity_recycler_title);
        mData = fillData();

        mRecyclerView = (RecyclerView)findViewById(R.id.rcView_recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerBookAdapter(this,mData,ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.rec_menu_lin:
                mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new RecyclerBookAdapter(this,mData,ATTR_LAYOUT_LIN);
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.rec_menu_grid:
                mLayoutManager = new GridLayoutManager(this,2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new RecyclerBookAdapter(this,mData,ATTR_LAYOUT_GRID);
                mRecyclerView.setAdapter(mAdapter);
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList fillData() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<20; i++){
            arrayList.add(new Book()
                    .setImage(R.drawable.img_book_morphine)
                    .setTitle("Морфий")
                    .setAuthor("Михаил Булгаков")
                    .setProgress(4));
        }
        return arrayList;
    }
}
