package com.bubble.swcamp.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geni on 2017. 8. 31..
 */

public class SignUp extends AppCompatActivity {
    private APIinterface apIinterface;
    private ImageView background;
    private Button signUpSubmitBtn;
    private EditText inputId;
    private EditText inputPw;
    private EditText inputNickName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        apIinterface = APIclient.getClient().create(APIinterface.class);
        background = (ImageView)findViewById(R.id.background);
        signUpSubmitBtn = (Button)findViewById(R.id.signUpSubmit);
        inputId = (EditText)findViewById(R.id.inputId);
        inputPw = (EditText)findViewById(R.id.inputPw);
        inputNickName = (EditText)findViewById(R.id.inputNickName);

        Glide.with(getApplicationContext())
                .load(R.drawable.bg_account)
                .into(background);

        signUpSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apIinterface.doSignUp(
                        inputId.getText().toString(),
                        inputPw.getText().toString(),
                        inputNickName.getText().toString()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 201){
                            Log.d("signUp", "Success");
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }
}
