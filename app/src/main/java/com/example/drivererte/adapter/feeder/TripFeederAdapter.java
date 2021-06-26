package com.example.drivererte.adapter.feeder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.activity.feeder.ChangeStatusActivityFeeder;
import com.example.drivererte.model.tripFeeder.TripFeederData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripFeederAdapter extends RecyclerView.Adapter<TripFeederAdapter.TripFeederHolder> {
    private Context ctx;
    private List<TripFeederData> listTripFeeder;

    public TripFeederAdapter(Context ctx, List<TripFeederData> listTripFeeder) {
        this.ctx = ctx;
        this.listTripFeeder = listTripFeeder;
    }

    @NonNull
    @Override
    public TripFeederHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip_feeder, parent, false);
        TripFeederHolder holder = new TripFeederHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TripFeederHolder holder, int position) {
        TripFeederData tripFeederData = listTripFeeder.get(position);

        holder.tvNama.setText(tripFeederData.getNamaPenumpang());
        holder.tvJenisKelamin.setText(tripFeederData.getJenisKelamin());
        holder.tvIdSeat.setText(tripFeederData.getIdSeat());
        holder.tvAlamat.setText(tripFeederData.getDetailAsal());
        holder.tvBiaya.setText(tripFeederData.getBiayaTambahan());
        holder.tvStatus.setText(tripFeederData.getStatus());
        holder.tvJadwal.setText(tripFeederData.getJadwal());

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Button Call", Toast.LENGTH_SHORT).show();
                Uri phoneNumber = Uri.parse("tel:" + tripFeederData.getNoHp());
                Intent callPassenger = new Intent(Intent.ACTION_DIAL, phoneNumber);
                ctx.startActivity(callPassenger);
            }
        });

        holder.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ctx, "Button change " +"Id Trip = " +tripFeederData.getIdTrip()+ " Id Pesanan = " +tripFeederData.getIdPesanan(), Toast.LENGTH_SHORT).show();
                Intent changeStatus = new Intent(ctx, ChangeStatusActivityFeeder.class);
                changeStatus.putExtra(ChangeStatusActivityFeeder.EXTRA_CHANGE_STATUS, tripFeederData);
                ctx.startActivity(changeStatus);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listTripFeeder.size();
    }

    public class TripFeederHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvJenisKelamin, tvIdSeat, tvAlamat, tvBiaya, tvStatus, tvJadwal;
        Button btnCall, btnChange;

        public TripFeederHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_passenger_name_feeder);
            tvJenisKelamin = itemView.findViewById(R.id.tv_passenger_gender_feeder);
            tvIdSeat = itemView.findViewById(R.id.tv_passenger_seat_feeder);
            tvAlamat = itemView.findViewById(R.id.tv_passenger_asal_feeder);
            tvBiaya = itemView.findViewById(R.id.tv_biaya_feeder);
            tvStatus = itemView.findViewById(R.id.tv_passenger_status_feeder);
            tvJadwal = itemView.findViewById(R.id.tv_jadwal_feeder);
            btnCall = itemView.findViewById(R.id.btn_call_feeder);
            btnChange = itemView.findViewById(R.id.btn_change_feeder);
        }
    }
}
