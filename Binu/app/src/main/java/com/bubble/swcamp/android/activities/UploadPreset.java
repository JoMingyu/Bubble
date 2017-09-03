package com.bubble.swcamp.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.SamplePhotoAdapter;
import com.bubble.swcamp.android.adapter.UploadPresetAdapter;
import com.bubble.swcamp.android.adapter.UploadedPresetAdapter;
import com.bubble.swcamp.android.items.Manager;
import com.bubble.swcamp.android.model.SampleImage;
import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadPreset extends AppCompatActivity {
    private EditText inputTitle, inputSummary, inputTag;
    private RecyclerView recyclerView;
    private APIinterface apiInterface;
    private Realm mRealm;
    private Button submit;
    private RealmResults<Manager> realmResults;
    private JSONArray jsonArray;
    private int hashCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_preset);
        recyclerView = (RecyclerView)findViewById(R.id.photo_recyclerView);
        recyclerView.setAdapter(new UploadPresetAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        submit = (Button) findViewById(R.id.submit);
        inputTitle = (EditText) findViewById(R.id.input_title);
        inputSummary = (EditText) findViewById(R.id.input_summary);
        inputTag = (EditText) findViewById(R.id.input_tag);

        mRealm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();
        realmResults = mRealm.where(Manager.class).findAll();
        apiInterface = APIclient.getClient().create(APIinterface.class);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                apiInterface.doUploadPreset(realmResults.get(0).getEmail(),
//                        inputTitle.getText().toString(),
//                        jsonArray,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0).enqueue(new Callback<JsonObject>() {
//                    @Override
//                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                        if(response.code() == 201){
//                            Intent intent = new Intent(getApplicationContext(), BubbleMarket.class);
//                            startActivity(intent);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<JsonObject> call, Throwable t) {
//
//                    }
//                });
//            }
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BubbleMarket.class));
            }
        });
    }

    public void onBackBtnClicked(View v){
        finish();
    }
    public void onHashTagsAdded(View v) throws JSONException {
        jsonArray.put(hashCount, inputTag.getText().toString());
    }
}
