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
    String Nama, Selected, jadwal, platMobil, status, idPemesan, idSeat, seat, statusDiSpinner;
    int orderNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);

        TripFeederData tripFeederData = getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS);
        Nama = tripFeederData.getNamaPenumpang();
        statusDiSpinner = tripFeederData.getStatus();
        jadwal = tripFeederData.getJadwalOriginal();
        platMobil = tripFeederData.getPlatMobil();
        idPemesan = tripFeederData.getIdPemesan();
        seat = tripFeederData.getIdSeat();
        orderNumber = tripFeederData.getOrder_number();

        String[] seatString = seat.split(" ");
        idSeat = seatString[1];

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Status by Feeder");

        tvName = findViewById(R.id.tv_nama);
        tvName.setText(Nama);

        spinnerStatus = findViewById(R.id.spinner_status);

        ArrayList<String> arrayList = new ArrayList<>();


        for (int i=0; i<3; i++){
            if (i == 0){
                arrayList.add("Booking");
            }else if (i == 1){
                arrayList.add("Picked Up");
            }else if (i == 2){
                arrayList.add("Cancelled");
            }else {
                arrayList.add("Status Baru");
            }
        }

        spinnerStatus.setAdapter(new ArrayAdapter<>(ChangeStatusActivityFeeder.this, android.R.layout.simple_spinner_dropdown_item,arrayList ));
        spinnerStatus.setSelection(getIndex(spinnerStatus, statusDiSpinner));
        btnUpdate = findViewById(R.id.btn_update);

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
                    case "Cancelled":
                        status = "5";
                        break;
                }

                System.out.println(jadwal+platMobil+idSeat+orderNumber+status);
                changeStatus();
            };
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