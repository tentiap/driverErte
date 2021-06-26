package com.example.drivererte.activity.feeder;

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
//import com.example.drivererte.model.changeStatusError.ChangeStatusError;
import com.example.drivererte.model.changeStatus.ChangeStatus;
import com.example.drivererte.model.tripFeeder.TripFeederData;

import java.util.ArrayList;

public class ChangeStatusActivityFeeder extends AppCompatActivity {
    public static final String EXTRA_CHANGE_STATUS = "extra_change_status";

    TextView tvName;
    Spinner spinnerStatus;
    Button btnUpdate;
    String Nama, Selected, idPesanan, idTrip, idSeat, seat, statusDiSpinner;
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);

        TripFeederData tripFeederData = getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS);
        Nama = tripFeederData.getNamaPenumpang();
        statusDiSpinner = tripFeederData.getStatus();
        idPesanan = tripFeederData.getIdPesanan();
        idTrip = tripFeederData.getIdTrip();
        seat = tripFeederData.getIdSeat();

        String[] seatString = seat.split(" ");
        idSeat = seatString[1];

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Status by Feeder");

        tvName = findViewById(R.id.tv_nama);
        tvName.setText(Nama);

        spinnerStatus = findViewById(R.id.spinner_status);

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

        spinnerStatus.setAdapter(new ArrayAdapter<>(ChangeStatusActivityFeeder.this, android.R.layout.simple_spinner_dropdown_item,arrayList ));
        spinnerStatus.setSelection(getIndex(spinnerStatus, statusDiSpinner));

        btnUpdate = findViewById(R.id.btn_update);

//        Toast.makeText(this, idSeat+ " - "+statusDiSpinner+ " - "+idPesanan+ " - "+idTrip , Toast.LENGTH_SHORT).show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = spinnerStatus.getSelectedItem().toString();
                switch (Selected){
                    case "Booking":
                        status = 1;
                        break;
                    case "Picked Up":
                        status = 2;
                        break;
                    case "On Going":
                        status = 3;
                        break;
                    case "Arrived":
                        status = 4;
                        break;
                    case "Cancelled":
                        status = 5;
                        break;
                }
//                Toast.makeText(ChangeStatusActivityFeeder.this, "Status = " +Selected+ " | Kode " +status, Toast.LENGTH_SHORT).show();
                changeStatus();
            };

//        Toast.makeText(ChangeStatusActivity.this, "Nama : " +Nama+ "Status : " +Status, Toast.LENGTH_SHORT).show();
//
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
        Call<ChangeStatus> changeStatusCall = apiInterface.changeStatusResponse(idPesanan, idTrip, idSeat, status);
        changeStatusCall.enqueue(new Callback<ChangeStatus>() {
            @Override
            public void onResponse(Call<ChangeStatus> call, Response<ChangeStatus> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(ChangeStatusActivityFeeder.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentBack = new Intent(ChangeStatusActivityFeeder.this, MainActivityFeeder.class);
                    startActivity(intentBack);
                } else {
                    Toast.makeText(ChangeStatusActivityFeeder.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChangeStatus> call, Throwable t) {
                Toast.makeText(ChangeStatusActivityFeeder.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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