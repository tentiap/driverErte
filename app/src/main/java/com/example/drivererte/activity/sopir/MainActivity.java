package com.example.drivererte.activity.sopir;

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
import com.example.drivererte.adapter.sopir.TripAdapter;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.tripSopir.TripSopir;
import com.example.drivererte.model.tripSopir.TripSopirData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTripSopir;
    private List<TripSopirData> listData = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    SessionManager sessionManager;
    TextView tvWelcome;
    String idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTripSopir = findViewById(R.id.rv_trip_sopir);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        progressBar = findViewById(R.id.progress_bar);

        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        idUser = sessionManager.getSopirDetail().get(SessionManager.ID_USERS);
        showTripSopir(idUser);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showTripSopir(idUser);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        tvWelcome = findViewById(R.id.tv_welcome);
        tvWelcome.setText("Welcome, " +sessionManager.getSopirDetail().get(SessionManager.NAMA) + "!");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        return true;
                    case R.id.bn_history:
                        startActivity(new Intent(MainActivity.this, HistoryActivity.class ));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(MainActivity.this, AccountActivity.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void showTripSopir(String idUser) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TripSopir> tripSopirCall = apiInterface.tripSopirResponse(idUser);
        tripSopirCall.enqueue(new Callback<TripSopir>() {
            @Override
            public void onResponse(Call<TripSopir> call, Response<TripSopir> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvTripSopir.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    String message = response.body().getMessage();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    final TripAdapter tripAdapter = new TripAdapter(MainActivity.this, listData);
                    rvTripSopir.setAdapter(tripAdapter);
                    tripAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    tripAdapter.setOnItemClickCallback(new TripAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(TripSopirData data) {
//                            Intent detailHistoryIntent = new Intent(MainActivity.this, DetailTripSopirActivity.class);
//                            detailHistoryIntent.putExtra(DetailOrderActivity.EXTRA_HISTORY_DATA, data);
//                            startActivity(detailHistoryIntent);
                            Toast.makeText(MainActivity.this, "You select " + data.getIdTrip(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    String message = response.body().getMessage();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<TripSopir> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}