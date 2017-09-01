package com.bubble.swcamp.android.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.fragments.FilterBrightnessFragment;
import com.bubble.swcamp.android.fragments.FilterSetupFragment;
import com.bubble.swcamp.android.fragments.FilterTemperatureFragment;

    public class PhotoFilter extends AppCompatActivity {

        public static final long ANIMATION_DURATION = 200L;
        private ImageButton brightness;
        private ImageButton temperature;
        private ImageButton setup;
        private boolean isCheck;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_filter);

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
                        return new FilterSetupFragment();
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

        private void setNextButtonText(int currentCount, int maxCount) {
      /*  if(currentCount + 1 == maxCount){
            next_button.setText("제출하기");
        }else{
            next_button.setText("다음 문항");
        }*/
        }
}
