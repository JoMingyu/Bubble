package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.bubble.swcamp.android.adapter.UploadedPresetAdapter;
import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.items.Manager;
import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadedPreset extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaded_preset);
        recyclerView = (RecyclerView)findViewById(R.id.uploaded_preset_items);

        recyclerView.setAdapter(new UploadedPresetAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void onBackBtnClicked(View v){
        finish();
    }
}
