package com.bubble.swcamp.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bubble.swcamp.android.adapter.MyPresetAdapter;
import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.items.Manager;
import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geni on 2017. 9. 1..
 */

public class MyPreset extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView filterBtn;
    private Realm mRealm;
    private APIinterface apiInterface;
    private ImageView addBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_preset);
        mRealm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView) findViewById(R.id.my_preset_items);
        apiInterface = APIclient.getClient().create(APIinterface.class);
        apiInterface.getOwnPreset(mRealm.where(Manager.class).findFirst().getEmail()).enqueue(new Callback<List<JsonObject>>() {
            @Override
            public void onResponse(Call<List<JsonObject>> call, Response<List<JsonObject>> response) {
                if(response.code() == 200){
                    recyclerView.setAdapter(new MyPresetAdapter(getApplicationContext(), response.body()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<List<JsonObject>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        filterBtn = (ImageView) findViewById(R.id.filterBtn);
        addBtn = (ImageView) findViewById(R.id.addBtn);

        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Filter.class));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UploadPreset.class));
            }
        });
    }

    public void onBackBtnClicked(View v){
        finish();
    }
}
