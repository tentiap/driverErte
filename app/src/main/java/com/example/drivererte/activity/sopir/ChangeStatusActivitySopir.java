package com.example.drivererte.activity.sopir;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.activity.feeder.MainActivityFeeder;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.changeStatus.ChangeStatus;
import com.example.drivererte.model.detailTripSopir.DetailTripSopirData;

public class ChangeStatusActivitySopir extends AppCompatActivity {
    public static final String EXTRA_CHANGE_STATUS_SOPIR = "extra_change_status_sopir";

    TextView tvName;
    Spinner spinnerStatus;
    Button btnUpdate;
    String Nama, status, Selected, idPesanan, idTrip, idSeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status_sopir);

        DetailTripSopirData detailTripSopirData = getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS_SOPIR);
        Nama = detailTripSopirData.getNamaPenumpang();
        status = detailTripSopirData.getStatus();
        idPesanan = detailTripSopirData.getIdPesanan();
        idTrip = detailTripSopirData.getIdTrip();
        idSeat = detailTripSopirData.getIdSeat();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Status by Driver");

        tvName = findViewById(R.id.tv_nama_sopir);
        tvName.setText(Nama);

        spinnerStatus = findViewById(R.id.spinner_status_sopir);
        btnUpdate = findViewById(R.id.btn_update_sopir);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = spinnerStatus.getSelectedItem().toString();
                switch (Selected){
                    case "Booking":
                        status = "1";
                        break;
                    case "Picked Up":
                        status = "2";
                        break;
                    case "On Going":
                        status = "3";
                        break;
                    case "Arrived":
                        status = "4";
                        break;
                    case "Cancelled":
                        status = "5";
                        break;
                }
                Toast.makeText(ChangeStatusActivitySopir.this, "Status = " +Selected+ " | Kode " +status, Toast.LENGTH_SHORT).show();
                changeStatus(idPesanan, idTrip, idSeat, status);
            }
        });
    }

    private void changeStatus(String idPesanan, String idTrip, String idSeat, String status) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ChangeStatus> changeStatusCall = apiInterface.changeStatusResponse(idPesanan, idTrip, idSeat, status);
        changeStatusCall.enqueue(new Callback<ChangeStatus>() {
            @Override
            public void onResponse(Call<ChangeStatus> call, Response<ChangeStatus> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(ChangeStatusActivitySopir.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentBack = new Intent(ChangeStatusActivitySopir.this, MainActivity.class);
                    startActivity(intentBack);
                } else {
                    Toast.makeText(ChangeStatusActivitySopir.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChangeStatus> call, Throwable t) {
                Toast.makeText(ChangeStatusActivitySopir.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

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
}