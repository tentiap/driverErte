package com.example.drivererte.activity.feeder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.example.drivererte.SessionManagerFeeder;
import com.example.drivererte.activity.sopir.LoginActivity;
import com.example.drivererte.activity.sopir.MainActivity;
import com.example.drivererte.adapter.feeder.TripFeederAdapter;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.tripFeeder.TripFeeder;
import com.example.drivererte.model.tripFeeder.TripFeederData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFeeder extends AppCompatActivity {
    private RecyclerView rvTripFeeder;
    private List<TripFeederData> listData = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
//    SessionManager sessionManagerFeeder;
    SessionManagerFeeder sessionManagerFeeder;
    TextView tvWelcome;
    String idUsersFeeder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feeder);

        rvTripFeeder = findViewById(R.id.rv_trip_feeder);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh3);
        progressBar = findViewById(R.id.progress_bar3);

        sessionManagerFeeder = new SessionManagerFeeder(MainActivityFeeder.this);
        if (!sessionManagerFeeder.isLoggedInFeeder()){
            moveToLogin();
        }

        tvWelcome = findViewById(R.id.tv_welcome_feeder);
        tvWelcome.setText("Welcome, " +sessionManagerFeeder.getFeederDetail().get(SessionManagerFeeder.NAMA) + "!");


        idUsersFeeder = sessionManagerFeeder.getFeederDetail().get(SessionManagerFeeder.ID_USERS);
        showTripFeeder(idUsersFeeder);


       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               swipeRefreshLayout.setRefreshing(true);
               showTripFeeder(idUsersFeeder);
               swipeRefreshLayout.setRefreshing(false);
           }
       });



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        return true;
//                    case R.id.bn_history:
//                        startActivity(new Intent(MainActivityFeeder.this, HistoryActivityFeeder.class ));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(MainActivityFeeder.this, AccountActivityFeeder.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }

    public void showTripFeeder(String idUsersFeeder) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TripFeeder> tripFeederCall = apiInterface.tripFeederResponse(idUsersFeeder);
        tripFeederCall.enqueue(new Callback<TripFeeder>() {
            @Override
            public void onResponse(Call<TripFeeder> call, Response<TripFeeder> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    rvTripFeeder.setLayoutManager(new LinearLayoutManager(MainActivityFeeder.this));
                    String message = response.body().getMessage();
                    Toast.makeText(MainActivityFeeder.this, message, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    final TripFeederAdapter tripFeederAdapter = new TripFeederAdapter(MainActivityFeeder.this, listData );
                    rvTripFeeder.setAdapter(tripFeederAdapter);
                    tripFeederAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);


                } else {
                    String message = response.body().getMessage();
                    Toast.makeText(MainActivityFeeder.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<TripFeeder> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivityFeeder.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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