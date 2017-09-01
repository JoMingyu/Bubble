package com.bubble.swcamp.android.model;



import android.graphics.Bitmap;

import com.bubble.swcamp.android.activities.Filter;
/**
 * Created by dsm2016 on 2017-09-01.
 */

public class FilterItem {
    private String mtitle;
    public com.zomato.photofilters.imageprocessors.Filter filter;

    public FilterItem(String title) {
        bitmap = null;
        this.mtitle=title;
        filter = new com.zomato.photofilters.imageprocessors.Filter();
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap bitmap;



    public String getTitle() {
        return mtitle;
    }


}