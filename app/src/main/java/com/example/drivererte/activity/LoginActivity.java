package com.example.drivererte.activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.loginSopir.LoginSopir;
import com.example.drivererte.model.loginSopir.LoginSopirData;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtPassword;
    Button btnLogin;
    String Email, Password;
    TextView tvLoginFeeder;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        tvLoginFeeder = findViewById(R.id.tv_login_feeder);
        tvLoginFeeder.setOnClickListener(this);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Email = edtEmail.getText().toString();
                Password = edtPassword.getText().toString();
                login(Email, Password);
                break;
            case R.id.tv_login_feeder:
                Intent intentLoginFeeder = new Intent(LoginActivity.this, LoginFeederActivity.class);
                startActivity(intentLoginFeeder);
        }
    }

    private void login(String email, String password) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginSopir> loginSopirCall = apiInterface.loginSopirResponse(email, password);
        loginSopirCall.enqueue(new Callback<LoginSopir>() {
            @Override
            public void onResponse(Call<LoginSopir> call, Response<LoginSopir> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginSopirData loginSopirData = response.body().getLoginSopirData();
                    sessionManager.createLoginSession(loginSopirData);

                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intentLogin);
                    finish();

                }else{
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginSopir> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}