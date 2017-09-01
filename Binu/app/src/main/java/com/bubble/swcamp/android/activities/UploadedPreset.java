package com.bubble.swcamp.android.activities;

import android.content.Intent;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geni on 2017. 9. 1..
 */

public class UploadedPreset extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText inputTitle, inputSummary, inputTag;
    private APIinterface apiInterface;
    private Realm mRealm;
    private RealmResults<Manager> realmResults;
    private JSONArray jsonArray;
    private int hashCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploaded_preset);
        mRealm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();
        realmResults = mRealm.where(Manager.class).findAll();

        recyclerView.setAdapter(new UploadedPresetAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        apiInterface = APIclient.getClient().create(APIinterface.class);

        apiInterface.doUploadPreset(realmResults.get(0).getEmail(),
                                    inputTitle.getText().toString(),
                                    jsonArray,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code() == 201){
                    startActivity(new Intent(getApplicationContext(), MyPreset.class));
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        inputTitle = (EditText) findViewById(R.id.input_title);
        inputSummary = (EditText) findViewById(R.id.input_summary);
        inputTag = (EditText) findViewById(R.id.input_tag);
    }

    public void onBackBtnClicked(View v){
        finish();
    }
    public void onHashTagsAdded(View v) throws JSONException {
        jsonArray.put(hashCount, inputTag.getText().toString());
    }
}
