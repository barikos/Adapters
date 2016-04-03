package com.minutes111.adapters.model;

/**
 * Created by barikos on 30.03.16.
 */
public class Book {

    private int mImage;
    private String mTitle;
    private String mAuthor;
    private int mProgress;

    public int getImage() {
        return mImage;
    }

    public Book setImage(int image) {
        this.mImage = image;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public Book setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public Book setAuthor(String author) {
        this.mAuthor = author;
        return this;
    }

    public int getProgress() {
        return mProgress;
    }

    public Book setProgress(int progress) {
        this.mProgress = progress;
        return this;
    }
}
