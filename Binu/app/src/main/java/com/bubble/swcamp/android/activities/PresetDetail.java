package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bumptech.glide.Glide;

/**
 * Created by geni on 2017. 9. 1..
 */

public class PresetDetail extends AppCompatActivity {
    private ImageView previewImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preset_detail);

        previewImage = (ImageView)findViewById(R.id.preview_image);
        Glide.with(getApplicationContext()).load(R.drawable.kyungsook).into(previewImage);
    }
}
