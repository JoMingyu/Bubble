package com.bubble.swcamp.android.model;

import com.bubble.swcamp.android.activities.Filter;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class FilterItem {
    private int image;
    private String title;

    public FilterItem(int image,String title){
        this.image=image;
        this.title=title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
