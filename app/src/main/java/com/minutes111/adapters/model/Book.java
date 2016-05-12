package com.minutes111.adapters.model;

/**
 * Created by barikos on 30.03.16.
 */
public class Book {

    private byte[] mImage;
    private String mName;
    private String mAuthor;
    private float mRating;

    public byte[] getImage() {
        return mImage;
    }

    public Book setImage(byte[] image) {
        this.mImage = image;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Book setName(String name) {
        this.mName = name;
        return this;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public Book setAuthor(String author) {
        this.mAuthor = author;
        return this;
    }

    public float getRating() {
        return mRating;
    }

    public Book setRating(int rating) {
        this.mRating = rating;
        return this;
    }
}
