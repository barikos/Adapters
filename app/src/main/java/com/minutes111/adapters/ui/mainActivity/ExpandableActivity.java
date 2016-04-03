package com.minutes111.adapters.ui.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.minutes111.adapters.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpandableActivity extends AppCompatActivity {

    private static final String ATTR_GROUP_NAME = "authorName";
    private static final String ATTR_CHILD_NAME = "bookName";

    private String[] mGroupsAuthor =  {"Михаил Булгаков","Эрнест Хемингуей"};

    private String[] mBulgakovBooks = {"Белаая гвардия","Собачье сердце"};
    private String[] mHemiBooks = {"Прощай оружие","По ком звонит колокол"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        setTitle(R.string.text_activity_exp_title);

        Map map;

        ArrayList<Map<String,String>> groupDataList = new ArrayList();
        for (String author: mGroupsAuthor){
            map = new HashMap();
            map.put(ATTR_GROUP_NAME,author);
            groupDataList.add(map);
        }

        String[] groupFrom = {ATTR_GROUP_NAME};
        int[] groupTo = {android.R.id.text1};
        String[] childFrom = {ATTR_CHILD_NAME};
        int[] childTo = {android.R.id.text1};

        ArrayList<ArrayList<Map<String,String>>> childDataList = new ArrayList<>();
        ArrayList<Map<String,String>> childDataItemList = new ArrayList<>();

        for (String book: mBulgakovBooks){
            map = new HashMap();
            map.put(ATTR_CHILD_NAME,book);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String book: mHemiBooks){
            map = new HashMap();
            map.put(ATTR_CHILD_NAME,book);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        SimpleExpandableListAdapter adapter =
                new SimpleExpandableListAdapter(this,
                        groupDataList,android.R.layout.simple_expandable_list_item_1,groupFrom,groupTo,
                        childDataList,android.R.layout.simple_list_item_1,childFrom,childTo);

        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.explView_expandable);
        expandableListView.setAdapter(adapter);
    }
}
