package com.minutes111.adapters.ui.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.minutes111.adapters.ui.adapter.BookAdapter;
import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Book;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        setTitle(R.string.text_activity_book_title);
        mData = fillData();

        BookAdapter adapter = new BookAdapter(this, mData);
        mListView = (ListView) findViewById(R.id.lView_books);
        mListView.setAdapter(adapter);
    }

    private ArrayList fillData(){
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
