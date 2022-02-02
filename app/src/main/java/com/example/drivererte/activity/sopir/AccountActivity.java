package com.example.drivererte.activity.sopir;

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

public class AccountActivity extends AppCompatActivity {

    SessionManager sessionManager;
    TextView tvName, tvUsername, tvEmail, tvPhone, tvGender, tvPlat, tvMerek;
    Button btnLogout;
    String name, username, email, phone, gender, plat, merek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        sessionManager = new SessionManager(AccountActivity.this);

        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvGender = findViewById(R.id.tv_gender);
        tvPlat = findViewById(R.id.tv_plat);
        tvMerek = findViewById(R.id.tv_merek);

        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });

        name = sessionManager.getSopirDetail().get(SessionManager.NAMA);
        email = sessionManager.getSopirDetail().get(SessionManager.EMAIL);
        username = sessionManager.getSopirDetail().get(SessionManager.USERNAME);
        phone = sessionManager.getSopirDetail().get(SessionManager.KONTAK);
        gender = sessionManager.getSopirDetail().get(SessionManager.JENIS_KELAMIN);
//        plat = sessionManager.getSopirDetail().get(SessionManager.PLAT);
//        merek = sessionManager.getSopirDetail().get(SessionManager.MEREK);

        tvName.setText(name);
        tvUsername.setText(username);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvGender.setText(gender);
        tvPlat.setText(plat);
        tvMerek.setText(merek);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_account);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(AccountActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_history:
                        startActivity(new Intent(AccountActivity.this, HistoryActivity.class));
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
        Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}