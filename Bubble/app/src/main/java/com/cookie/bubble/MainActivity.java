package com.cookie.bubble;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.cookie.bubble.custom.Filter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar_contrast = (SeekBar) findViewById(R.id.sb_contrast);

        final ImageView imageView = (ImageView) findViewById(R.id.iv_sample);

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        final Bitmap bitmapImage = drawable.getBitmap();

        seekbar_contrast.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Bitmap newBitmap = Filter.adjustBrightness(bitmapImage, progress);
                imageView.setImageBitmap(newBitmap);
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
