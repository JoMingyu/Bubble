package com.bubble.swcamp.android.utils;


import android.content.Context;
import android.graphics.Bitmap;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.model.FilterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class FilterltemManger {
    private static List<FilterItem> filterItemList=new ArrayList<>();
    private static List<FilterItem> filterProcessed=new ArrayList<>();

    private FilterltemManger(){

    }


    public static void addItem(FilterItem filterItem){
        filterItemList.add(filterItem);
    }

    public static List<FilterItem> processThumbs(Context context) {
        for (FilterItem thumb : filterItemList) {
            // scaling down the
            float size = context.getResources().getDimension(R
                    .dimen.thumbnail_size);
            thumb.bitmap = Bitmap.createScaledBitmap(thumb.bitmap, (int) size, (int) size, false);
            thumb.bitmap = thumb.filter.processFilter(thumb.bitmap);
            filterProcessed.add(thumb);
        }
        return filterItemList;
    }

    public static void clearFilter(){
        filterItemList=new ArrayList<>();
        filterProcessed=new ArrayList<>();
    }
}