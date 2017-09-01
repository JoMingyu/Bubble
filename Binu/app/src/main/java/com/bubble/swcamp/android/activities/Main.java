package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.MainRankerPagerAdapter;

/**
 * Created by geni on 2017. 8. 31..
 */

public class Main extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = (ViewPager)findViewById(R.id.ranker);
        tabLayout = (TabLayout)findViewById(R.id.tabDots);
        recyclerView = (RecyclerView)findViewById(R.id.filters);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new MainRankerPagerAdapter(getApplicationContext()));
    }
}
