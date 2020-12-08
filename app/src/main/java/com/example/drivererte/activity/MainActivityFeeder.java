package com.example.drivererte.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityFeeder extends AppCompatActivity {

    SessionManager sessionManager;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feeder);

        sessionManager = new SessionManager(MainActivityFeeder.this);
        if (!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        tvWelcome = findViewById(R.id.tv_welcome_feeder);
        tvWelcome.setText("Welcome, " +sessionManager.getFeederDetail().get(SessionManager.NAMA) + "!");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        return true;
                    case R.id.bn_history:
                        startActivity(new Intent(MainActivityFeeder.this, HistoryActivityFeeder.class ));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(MainActivityFeeder.this, AccountActivityFeeder.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivityFeeder.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}