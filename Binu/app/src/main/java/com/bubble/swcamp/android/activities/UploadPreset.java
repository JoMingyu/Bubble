package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.SamplePhotoAdapter;
import com.bubble.swcamp.android.adapter.UploadPresetAdapter;
import com.bubble.swcamp.android.model.SampleImage;

import java.util.ArrayList;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadPreset extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_preset);
        recyclerView = (RecyclerView)findViewById(R.id.photo_recyclerView);
        recyclerView.setAdapter(new UploadPresetAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
    }

    public void onBackBtnClicked(View v){
        finish();
    }
}
