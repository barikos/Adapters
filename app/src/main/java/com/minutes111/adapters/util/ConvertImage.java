package com.minutes111.adapters.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by barikos on 26.04.16.
 */
public class ConvertImage {

    public static byte[] getBytesImage(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap getBitmapImage(byte[] image){
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }
}
