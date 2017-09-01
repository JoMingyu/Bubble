package com.bubble.swcamp.android.activities;


import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.fragments.FilterBrightnessFragment;
import com.bubble.swcamp.android.fragments.FilterSetupFragment;
import com.bubble.swcamp.android.fragments.FilterTemperatureFragment;
import com.zomato.photofilters.imageprocessors.*;

public class PhotoFilter extends AppCompatActivity {

    static{
        System.loadLibrary("NativeImageProcessor");
    }



    public static final long ANIMATION_DURATION = 200L;
    private ImageButton brightness;
    private ImageButton temperature;
    private ImageButton setup;
    private boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        setButton();
        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        binding();

        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,false);
            }
        });

        brightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,false);
            }
        });

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2,false);
            }
        });





    }

    public void binding(){
        brightness=(ImageButton)findViewById(R.id.bright_image);
        temperature=(ImageButton)findViewById(R.id.template_image);
        setup=(ImageButton)findViewById(R.id.setup_image);
    }


    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("xxx Main", "getItem: " + position);
            switch (position){
                case 0:
                    return new FilterSetupFragment(getApplicationContext());
                case 1:
                    return new FilterBrightnessFragment();
                case 2:
                    return  new FilterTemperatureFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public void changeImage(int image){
        ImageView mainView=(ImageView)findViewById(R.id.main_image);
        mainView.setImageBitmap(BitmapFactory.decodeResource(getResources(),image));
    }

    public void changeFilter(com.zomato.photofilters.imageprocessors.Filter filter){

    }


    public void setButton(){
        ImageButton backButton=(ImageButton) findViewById(R.id.ib_toolbar_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
