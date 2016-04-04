package com.minutes111.adapters.ui.mainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Data;
import com.minutes111.adapters.ui.adapter.GenreAdapter;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity {

    private GridView mGridView;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        setTitle(R.string.text_activity_genre_title);

        Data data = new Data();
        mData = data.getGenreData();

        GenreAdapter adapter = new GenreAdapter(this, mData);
        mGridView = (GridView)findViewById(R.id.grView_genre);
        mGridView.setAdapter(adapter);
    }


}
