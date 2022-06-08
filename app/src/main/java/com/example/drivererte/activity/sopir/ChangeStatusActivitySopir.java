package com.example.drivererte.activity.sopir;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.api.ApiClient;
import com.example.drivererte.api.ApiInterface;
import com.example.drivererte.model.changeStatus.ChangeStatus;
import com.example.drivererte.model.detailTripSopir.DetailTripSopirData;

import java.util.ArrayList;

public class ChangeStatusActivitySopir extends AppCompatActivity {
    public static final String EXTRA_CHANGE_STATUS_SOPIR = "extra_change_status_sopir";

    TextView tvName;
    Spinner spinnerStatus;
    Button btnUpdate;
    int orderNumber;
    String Nama, Selected, seat, statusDiSpinner, idSeat, status, jadwal, platMobil, idPemesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status_sopir);

        DetailTripSopirData detailTripSopirData= getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS_SOPIR);
        Nama = detailTripSopirData.getNamaPenumpang();
        System.out.println("Nama: "+Nama);
        statusDiSpinner = detailTripSopirData.getStatus();
        System.out.println("Status di spinner: "+statusDiSpinner);
        jadwal = detailTripSopirData.getJadwal();
        platMobil = detailTripSopirData.getPlatMobil();
        idPemesan = detailTripSopirData.getIdPemesan();
//        orderNumber = detailTripSopirData.getOrderNumber();
        seat = detailTripSopirData.getIdSeat();

        String[] seatString = seat.split(" ");
        idSeat = seatString[1];

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Status by Driver");

        tvName = findViewById(R.id.tv_nama_sopir);
        tvName.setText(Nama);

        spinnerStatus = findViewById(R.id.spinner_status_sopir);

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i=0; i<5; i++){
            if (i == 0){
                arrayList.add("Booking");
            }else if (i == 1){
                arrayList.add("Picked Up");
            }else if (i == 2){
                arrayList.add("On Going");
            }else if (i == 3){
                arrayList.add("Arrived");
            }else if (i == 4){
                arrayList.add("Cancelled");
            }else {
                arrayList.add("Status Baru");
            }
        }

        spinnerStatus.setAdapter(new ArrayAdapter<>(ChangeStatusActivitySopir.this, android.R.layout.simple_spinner_dropdown_item,arrayList));
        spinnerStatus.setSelection(getIndex(spinnerStatus, statusDiSpinner));
        btnUpdate = findViewById(R.id.btn_update_sopir);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                changeStatus();
            }
        });
    }

    private int getIndex(Spinner spinnerStatus, String statusDiSpinner) {
        for (int i=0; i < spinnerStatus.getCount(); i++){
            if (spinnerStatus.getItemAtPosition(i).toString().equalsIgnoreCase(statusDiSpinner)){
                return i;
            }
        }
        return 0;
    }

    private void changeStatus() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ChangeStatus> changeStatusCall = apiInterface.changeStatusResponse(jadwal, platMobil, idSeat, idPemesan, status);
        changeStatusCall.enqueue(new Callback<ChangeStatus>() {
            @Override
            public void onResponse(Call<ChangeStatus> call, Response<ChangeStatus> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(ChangeStatusActivitySopir.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentBack = new Intent(ChangeStatusActivitySopir.this, DetailTripSopirActivity.class);

                    intentBack.putExtra(DetailTripSopirActivity.EXTRA_TRIP_JADWAL, jadwal);
                    intentBack.putExtra(DetailTripSopirActivity.EXTRA_TRIP_MOBIL, platMobil);
                    startActivity(intentBack);
                    finish();
                }else{
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