package com.example.drivererte.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivityFeeder extends AppCompatActivity {
    SessionManager sessionManager;
    TextView tvName, tvUsername, tvEmail, tvPhone, tvGender, tvWilayah;
    Button btnLogout;
    String name, username, email, phone, gender, wilayah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_feeder);

        sessionManager = new SessionManager(AccountActivityFeeder.this);

        tvName = findViewById(R.id.tv_name_feeder);
        tvUsername = findViewById(R.id.tv_username_feeder);
        tvEmail = findViewById(R.id.tv_email_feeder);
        tvPhone = findViewById(R.id.tv_phone_feeder);
        tvGender = findViewById(R.id.tv_gender_feeder);
        tvWilayah = findViewById(R.id.tv_wilayah);

        btnLogout = findViewById(R.id.btn_logout_feeder);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });

        name = sessionManager.getFeederDetail().get(SessionManager.NAMA);
        email = sessionManager.getFeederDetail().get(SessionManager.EMAIL);
        username = sessionManager.getFeederDetail().get(SessionManager.USERNAME);
        phone = sessionManager.getFeederDetail().get(SessionManager.KONTAK);
        gender = sessionManager.getFeederDetail().get(SessionManager.JENIS_KELAMIN);
        wilayah = sessionManager.getFeederDetail().get(SessionManager.WILAYAH);

        tvName.setText(name);
        tvUsername.setText(username);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvGender.setText(gender);
        tvWilayah.setText(wilayah);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_account);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(AccountActivityFeeder.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_history:
                        startActivity(new Intent(AccountActivityFeeder.this, HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        return true;
                }
                return false;
            }
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(AccountActivityFeeder.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}