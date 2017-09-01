package com.bubble.swcamp.android.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by dsm2016 on 2017-09-01.
 */

public class UnScrollViewPager extends ViewPager {

    private boolean enabled;

    public UnScrollViewPager(Context context) {
        super(context);
    }

    public UnScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

}
