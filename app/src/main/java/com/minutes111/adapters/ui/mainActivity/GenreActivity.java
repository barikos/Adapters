package com.minutes111.adapters.ui.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.minutes111.adapters.ui.adapter.GenreAdapter;
import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Genre;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity {

    private GridView mGridView;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        setTitle(R.string.text_activity_genre_title);
        mData = fillData();

        GenreAdapter adapter = new GenreAdapter(this, mData);
        mGridView = (GridView)findViewById(R.id.grView_genre);
        mGridView.setAdapter(adapter);
    }

    private ArrayList fillData(){
        ArrayList arrayList = new ArrayList();
        for (int i=0; i<10; i++){
            arrayList.add(new Genre()
                                .setImage(R.drawable.img_genre_fantasy)
                                .setName("Fantasy"));
        }
        return arrayList;
    }
}
