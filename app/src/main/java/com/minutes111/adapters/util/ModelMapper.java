package com.minutes111.adapters.util;

import android.database.Cursor;
import android.util.Log;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.model.Book;
import com.minutes111.adapters.ui.DBContact;

import java.util.ArrayList;

/**
 * Created by barikos on 27.04.16.
 */
public class ModelMapper {
    public static ArrayList<Book> getListBookModel(Cursor cursor){
        ArrayList arrayList = new ArrayList();
        if (cursor!=null){
            if (cursor.moveToFirst()){
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(DBContact.KEY_ID));
                    String name = cursor.getString(cursor.getColumnIndex(DBContact.KEY_NAME));
                    String author = cursor.getString(cursor.getColumnIndex(DBContact.KEY_AUTH));
                    byte[] img = cursor.getBlob(cursor.getColumnIndex(DBContact.KEY_IMG));
                    int rating = cursor.getInt(cursor.getColumnIndex(DBContact.KEY_RATING));

                    arrayList.add(new Book()
                            .setName(name)
                            .setAuthor(author)
                            .setImage(img)
                            .setRating(rating));
                    Log.d(Const.LOG_TAG, id + " " + name + " ");
                }while (cursor.moveToNext());
            }else {
                Log.d(Const.LOG_TAG,"Cursor is null");
            }
        }
        return arrayList;
    }
}
