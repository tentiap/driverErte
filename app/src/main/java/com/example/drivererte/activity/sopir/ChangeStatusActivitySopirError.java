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
//import com.example.drivererte.model.changeStatusError.ChangeStatusError;
import com.example.drivererte.model.changeStatusError.ChangeStatusError;
import com.example.drivererte.model.detailTripSopir.DetailTripSopirData;

import java.util.ArrayList;

public class ChangeStatusActivitySopirError extends AppCompatActivity {
    public static final String EXTRA_CHANGE_STATUS_SOPIR = "extra_change_status_sopir";

    TextView tvName;
    Spinner spinnerStatus;
    Button btnUpdate;
    String Nama;
    Integer status;
    String Selected, idPesanan, idTrip, idSeat, statusDiSpinner;
//    String idPesanan;
//    String idTrip;
//    String idSeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status_sopir_error);

        DetailTripSopirData detailTripSopirData = getIntent().getParcelableExtra(EXTRA_CHANGE_STATUS_SOPIR);
        Nama = detailTripSopirData.getNamaPenumpang();
        statusDiSpinner = detailTripSopirData.getStatus(); //Karena status tidak tau di spinner, jadinya ndak dipakai
        idPesanan = detailTripSopirData.getIdPesanan();
        idTrip = detailTripSopirData.getIdTrip();
        idSeat = detailTripSopirData.getIdSeat();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Edit Status by Driver");

        tvName = findViewById(R.id.tv_nama_sopir);
        tvName.setText(Nama);

        spinnerStatus = findViewById(R.id.spinner_status_sopir);

//        ArrayAdapter myAdap = (ArrayAdapter) spinnerStatus.getAdapter();
//        int spinnerPosition = myAdap.getPosition(statusDiSpinner);
//        spinnerStatus.setSelection(spinnerPosition);

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

        spinnerStatus.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrayList));
        spinnerStatus.setSelection(getIndex(spinnerStatus, statusDiSpinner));
//        Toast.makeText(this, statusDiSpinner, Toast.LENGTH_SHORT).show();
//        spinnerStatus.setSelection(Integer.parseInt(statusDiSpinner));

        btnUpdate = findViewById(R.id.btn_update_sopir);

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
//                Toast.makeText(ChangeStatusActivitySopir.this, "Status = " +Selected+ " | Kode " +status, Toast.LENGTH_SHORT).show();
                changeStatus(idPesanan, idTrip, idSeat, status);
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

    private void changeStatus(String idPesanan, String idTrip, String idSeat, Integer status) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ChangeStatusError> changeStatusCall = apiInterface.changeStatusResponse(idPesanan, idTrip, idSeat, status);
        changeStatusCall.enqueue(new Callback<ChangeStatusError>() {
            @Override
            public void onResponse(Call<ChangeStatusError> call, Response<ChangeStatusError> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(ChangeStatusActivitySopirError.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intentBack = new Intent(ChangeStatusActivitySopirError.this, MainActivity.class);
                    startActivity(intentBack);
                } else {
//                    Toast.makeText(ChangeStatusActivitySopir.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(ChangeStatusActivitySopirError.this, "Upss data tidak ditemukan", Toast.LENGTH_SHORT).show();

                }
//                Toast.makeText(ChangeStatusActivitySopir.this, "Id Pesanan = " +idPesanan+ " | id Trip " +idTrip+ "Id Seat = " +idSeat+ " | Status " +status, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ChangeStatusError> call, Throwable t) {
                Toast.makeText(ChangeStatusActivitySopirError.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ChangeStatusActivitySopir.this, "Upss data tidak ditemukan", Toast.LENGTH_SHORT).show();


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