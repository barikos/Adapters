package com.minutes111.adapters.ui.mainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Data;
import com.minutes111.adapters.ui.adapter.BookAdapter;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        setTitle(R.string.text_activity_book_title);

        Data data = new Data();
        mData = data.getBooksData();

        BookAdapter adapter = new BookAdapter(this, mData);
        mListView = (ListView) findViewById(R.id.lView_books);
        mListView.setAdapter(adapter);
    }


}
