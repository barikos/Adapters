package com.minutes111.adapters.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.util.ConvertImage;

/**
 * Created by barikos on 26.04.16.
 */
public class DBHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String CREATE_TABLE =
            String.format("create table %s(%s integer primary key autoincrement, %s text,%s text,%s blob, %s integer)",
                    DBContact.TABLE_NAME, DBContact.KEY_ID, DBContact.KEY_NAME,
                    DBContact.KEY_AUTH, DBContact.KEY_IMG, DBContact.KEY_RATING);

    public DBHelper(Context context) {
        super(context, DBContact.DB_NAME, null, DBContact.DB_VERSION_INITIAL);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        ContentValues cv = new ContentValues();
        Log.d(Const.LOG_TAG,String.valueOf(Const.BOOKS.length));
        for (int i=0; i< Const.BOOKS.length; i++){
            cv.clear();
            cv.put(DBContact.KEY_NAME, Const.BOOKS[i]);
            cv.put(DBContact.KEY_AUTH, Const.AUTHORS[i]);
            cv.put(DBContact.KEY_IMG, ConvertImage.getBytesImage(imgToBitmap(Const.IMAGES_BOOK[i])));
            cv.put(DBContact.KEY_RATING,Const.RATING[i]);
            db.insert(DBContact.TABLE_NAME,null,cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private Bitmap imgToBitmap(int id){
        return BitmapFactory.decodeResource(mContext.getResources(), id);
    }
}
