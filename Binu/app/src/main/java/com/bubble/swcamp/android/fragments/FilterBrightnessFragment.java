package com.bubble.swcamp.android.fragments;


import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bubble.swcamp.android.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilterBrightnessFragment extends Fragment {

    private SeekBar seekBar;
    private TextView seekBarSize;
    private int brightness;
    private ContentResolver cResolver;
    private Window window;



    public FilterBrightnessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_filter_bigthness, container, false);

        setSeekBar(view);
        return view;
    }


    private void setSeekBar(View rootView){
        seekBar=(SeekBar)rootView.findViewById(R.id.bright_area_seekBar);
        seekBarSize=(TextView)rootView.findViewById(R.id.bright_area_size);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
