package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bubble.swcamp.android.adapter.UploadedPresetAdapter;
import com.bubble.swcamp.android.R;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadedPreset extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaded_preset);

        recyclerView.setAdapter(new UploadedPresetAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
