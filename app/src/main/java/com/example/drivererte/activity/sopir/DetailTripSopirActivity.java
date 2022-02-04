package com.example.drivererte.activity.sopir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.adapter.sopir.DetailTripSopirAdapter;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.detailTripSopir.DetailTripSopir;
import com.example.drivererte.model.detailTripSopir.DetailTripSopirData;

import java.util.ArrayList;
import java.util.List;

public class DetailTripSopirActivity extends AppCompatActivity {
    public static final String EXTRA_TRIP_DATA = "extra_trip_data";
    private RecyclerView rvDetailTripSopir;
    private List<DetailTripSopirData> list = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    String idTrip, jadwal, platMobil, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trip_sopir);

        rvDetailTripSopir = findViewById(R.id.rv_detail_trip_sopir);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh1);
        progressBar = findViewById(R.id.progress_bar1);

//        idTrip = getIntent().getStringExtra(EXTRA_TRIP_DATA);
//        Toast.makeText(DetailTripSopirActivity.this, "ID Trip: " +idTrip, Toast.LENGTH_SHORT).show();
        data = getIntent().getStringExtra(EXTRA_TRIP_DATA);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail Trip " + idTrip);

        showTripDetail(idTrip);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                showTripDetail(idTrip);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showTripDetail(String idTrip) {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DetailTripSopir> detailTripSopirCall = apiInterface.detailTripSopirResponse(jadwal, platMobil);
        detailTripSopirCall.enqueue(new Callback<DetailTripSopir>() {
            @Override
            public void onResponse(Call<DetailTripSopir> call, Response<DetailTripSopir> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    rvDetailTripSopir.setLayoutManager(new LinearLayoutManager(DetailTripSopirActivity.this));
                    String message = response.body().getMessage();
                    Toast.makeText(DetailTripSopirActivity.this, message, Toast.LENGTH_SHORT).show();
                    list = response.body().getData();

                    final DetailTripSopirAdapter detailTripSopirAdapter = new DetailTripSopirAdapter(DetailTripSopirActivity.this, list);
                    rvDetailTripSopir.setAdapter(detailTripSopirAdapter);
                    detailTripSopirAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);

                }else {
                    String message = response.body().getMessage();
                    Toast.makeText(DetailTripSopirActivity.this, message, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<DetailTripSopir> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(DetailTripSopirActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}