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
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.loginFeeder.LoginFeeder;
import com.example.drivererte.model.loginFeeder.LoginFeederData;
import com.example.drivererte.model.loginSopir.LoginSopirData;

public class LoginFeederActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtEmail, edtPassword;
    Button btnLogin;
    String Email, Password;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_feeder);

        edtEmail = findViewById(R.id.edt_email_feeder);
        edtPassword = findViewById(R.id.edt_password_feeder);

        btnLogin = findViewById(R.id.btn_login_feeder);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Email = edtEmail.getText().toString();
        Password = edtPassword.getText().toString();
        loginFeeder(Email, Password);
    }

    private void loginFeeder(String email, String password) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginFeeder> loginFeederCall = apiInterface.loginFeederResponse(email, password);
        loginFeederCall.enqueue(new Callback<LoginFeeder>() {
            @Override
            public void onResponse(Call<LoginFeeder> call, Response<LoginFeeder> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(LoginFeederActivity.this);
                    LoginFeederData loginFeederData = response.body().getLoginFeederData();
                    sessionManager.createLoginFeederSession(loginFeederData);

                    Toast.makeText(LoginFeederActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentLogin = new Intent(LoginFeederActivity.this, MainActivityFeeder.class);
                    startActivity(intentLogin);
                    finish();

                }else{
                    Toast.makeText(LoginFeederActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginFeeder> call, Throwable t) {
                Toast.makeText(LoginFeederActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}