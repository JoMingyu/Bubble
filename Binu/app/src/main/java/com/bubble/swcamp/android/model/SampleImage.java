package com.bubble.swcamp.android.model;

import android.graphics.Bitmap;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class SampleImage {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public SampleImage(int image) {
        this.image = image;
    }

    int image;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public SampleImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    Bitmap bitmap;

}
