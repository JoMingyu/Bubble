package com.bubble.swcamp.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.items.Manager;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 31..
 */

public class Splash extends AppCompatActivity {
    private Realm realm;
    private RealmResults<Manager> realmResults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), SignIn.class));
                finish();
            }
        }, 2000);
    }
}
