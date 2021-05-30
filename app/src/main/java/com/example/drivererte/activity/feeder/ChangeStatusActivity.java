package com.example.drivererte.activity.feeder;

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
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
//import com.example.drivererte.model.changeStatusError.ChangeStatusError;
import com.example.drivererte.model.tripFeeder.TripFeederData;

public class ChangeStatusActivity extends AppCompatActivity {
    public static final String EXTRA_CHANGE_STATUS = "extra_change_status";

    TextView tvName;
    Spinner spinnerStatus;
    Button btnUpdate;
    String Nama, Selected, idPesanan, idTrip, idSeat;
    Integer status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);

//        TripFeederData tripFeederData = getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS);
//        Nama = tripFeederData.getNamaPenumpang();
//        status = Integer.valueOf(tripFeederData.getStatus());
//        idPesanan = tripFeederData.getIdPesanan();
//        idTrip = tripFeederData.getIdTrip();
//        idSeat = tripFeederData.getIdSeat();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("Edit Status");
//
//        tvName = findViewById(R.id.tv_nama);
//        tvName.setText(Nama);
//
//        spinnerStatus = findViewById(R.id.spinner_status);
//        btnUpdate = findViewById(R.id.btn_update);
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Selected = spinnerStatus.getSelectedItem().toString();
//                switch (Selected){
//                    case "Booking":
//                        status = 1;
//                        break;
//                    case "Picked Up":
//                        status = 2;
//                        break;
//                    case "On Going":
//                        status = 3;
//                        break;
//                    case "Arrived":
//                        status = 4;
//                        break;
//                    case "Cancelled":
//                        status = 5;
//                        break;
//                }
//                Toast.makeText(ChangeStatusActivity.this, "Status = " +Selected+ " | Kode " +status, Toast.LENGTH_SHORT).show();
//                changeStatus(idPesanan, idTrip, idSeat, status);
//            };
//
////        Toast.makeText(ChangeStatusActivity.this, "Nama : " +Nama+ "Status : " +Status, Toast.LENGTH_SHORT).show();
//
//        });
    }

//    private void changeStatus(String idPesanan, String idTrip, String idSeat, Integer status) {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<ChangeStatusError> changeStatusCall = apiInterface.changeStatusResponse(idPesanan, idTrip, idSeat, status);
//        changeStatusCall.enqueue(new Callback<ChangeStatusError>() {
//            @Override
//            public void onResponse(Call<ChangeStatusError> call, Response<ChangeStatusError> response) {
//                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
//                    Toast.makeText(ChangeStatusActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    Intent intentBack = new Intent(ChangeStatusActivity.this, MainActivityFeeder.class);
//                    startActivity(intentBack);
//                } else {
//                    Toast.makeText(ChangeStatusActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ChangeStatusError> call, Throwable t) {
//                Toast.makeText(ChangeStatusActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
}