package com.minutes111.adapters.model;

/**
 * Created by barikos on 30.03.16.
 */
public class Genre {
    private int mImage;
    private String mName;

    public int getImage() {
        return mImage;
    }

    public Genre setImage(int image) {
        this.mImage = image;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Genre setName(String name) {
        this.mName = name;
        return this;
    }
}
