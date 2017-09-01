package com.bubble.swcamp.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;
import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geni on 2017. 9. 1..
 */

public class PresetDetail extends AppCompatActivity {
    private ImageView previewImage;
    private Intent intent;
    private APIinterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preset_detail);
        intent = getIntent();
        apiInterface = APIclient.getClient().create(APIinterface.class);
        apiInterface.getPresetDetail(intent.getIntExtra("preset_id", 0)).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code() == 200){
                    Log.d("response", response.body()+"");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });


        previewImage = (ImageView)findViewById(R.id.preview_image);
        Glide.with(getApplicationContext()).load(R.drawable.kyungsook).into(previewImage);
    }

    public void onBackBtnClicked(View v){
        finish();
    }
}
