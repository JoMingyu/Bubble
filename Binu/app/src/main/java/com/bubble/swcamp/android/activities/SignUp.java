package com.bubble.swcamp.android.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
    private EditText inputEmail;
    private EditText inputPw;
    private EditText confirmPw;
    private EditText inputNickName;
    private Button maleBtn;
    private Button femaleBtn;
    private String gender = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        apIinterface = APIclient.getClient().create(APIinterface.class);
        background = (ImageView)findViewById(R.id.background);
        signUpSubmitBtn = (Button)findViewById(R.id.signUpSubmit);
        inputId = (EditText)findViewById(R.id.inputId);
        inputEmail = (EditText)findViewById(R.id.inputEmail);
        inputPw = (EditText)findViewById(R.id.inputPw);
        confirmPw = (EditText)findViewById(R.id.confirmPw);
        inputNickName = (EditText)findViewById(R.id.inputNickName);
        maleBtn = (Button)findViewById(R.id.male);
        femaleBtn = (Button)findViewById(R.id.female);

        Glide.with(getApplicationContext())
                .load(R.drawable.bg_account)
                .into(background);

        signUpSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apIinterface.doSignUp(
                        inputId.getText().toString(),
                        inputEmail.getText().toString(),
                        inputPw.getText().toString(),
                        inputNickName.getText().toString(),
                        gender).enqueue(new Callback<Void>() {
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

    public void setGender(View v){
        switch (v.getId()){
            case R.id.male:
                gender = "m";
                femaleBtn.setBackgroundResource(R.drawable.female);
                maleBtn.setBackgroundResource(R.drawable.male_selected);
                break;
            case R.id.female:
                gender = "f";
                maleBtn.setBackgroundResource(R.drawable.male);
                femaleBtn.setBackgroundResource(R.drawable.female_selected);
                break;
            default: break;
        }
    }
}
