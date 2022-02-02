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
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.SessionManager;
import com.example.drivererte.adapter.sopir.HistoryAdapter;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.historySopir.HistorySopir;
import com.example.drivererte.model.historySopir.HistorySopirData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView rvHistory;
    private List<HistorySopirData> listData = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    SessionManager sessionManager;
    String idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory = findViewById(R.id.rv_history_sopir);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        progressBar = findViewById(R.id.progress_bar);

        sessionManager = new SessionManager(HistoryActivity.this);
        idUser = sessionManager.getSopirDetail().get(SessionManager.ID_SOPIR);
        showHistorySopir(idUser);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showHistorySopir(idUser);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bn_history);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_home:
                        startActivity(new Intent(HistoryActivity.this, MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bn_history:
                        return true;
                    case R.id.bn_account:
                        startActivity(new Intent(HistoryActivity.this, AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void showHistorySopir(String idUser) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<HistorySopir> historySopirCall = apiInterface.historySopirResponse(idUser);
        historySopirCall.enqueue(new Callback<HistorySopir>() {
            @Override
            public void onResponse(Call<HistorySopir> call, Response<HistorySopir> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvHistory.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
                    String message = response.body().getMessage();
                    Toast.makeText(HistoryActivity.this, message, Toast.LENGTH_SHORT).show();
                    listData = response.body().getData();

                    HistoryAdapter historyAdapter = new HistoryAdapter(HistoryActivity.this, listData);
                    rvHistory.setAdapter(historyAdapter);
                    historyAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                    historyAdapter.setOnItemClickCallback(new HistoryAdapter.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(HistorySopirData data) {
                            Toast.makeText(HistoryActivity.this, "You select " + data.getIdTrip(), Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    String message = response.body().getMessage();
                    Toast.makeText(HistoryActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);

                }

                }

            @Override
            public void onFailure(Call<HistorySopir> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(HistoryActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}