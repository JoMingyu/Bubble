package com.bubble.swcamp.android;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bubble.swcamp.android.network.APIclient;
import com.bubble.swcamp.android.network.APIinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
    private APIinterface apIinterface;
    private Button signInSubmitBtn;
    private EditText inputId;
    private EditText inputPw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        apIinterface = APIclient.getClient().create(APIinterface.class);
        signInSubmitBtn = (Button)findViewById(R.id.signInSubmit);
        inputId = (EditText)findViewById(R.id.inputId);
        inputPw = (EditText)findViewById(R.id.inputPw);

        signInSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apIinterface.doSignIn(inputId.getText().toString(), inputPw.getText().toString()).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), Main.class));
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
