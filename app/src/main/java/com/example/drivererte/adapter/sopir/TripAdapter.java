package com.example.drivererte.adapter.sopir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drivererte.R;
import com.example.drivererte.model.tripSopir.TripSopirData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripHolder> {
    private Context ctx;
    private List<TripSopirData> listTrip;

    public TripAdapter(Context ctx, List<TripSopirData> listTrip) {
        this.ctx = ctx;
        this.listTrip = listTrip;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public TripHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_trip, parent, false);
        TripHolder holder = new TripHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TripHolder holder, int position) {
        TripSopirData tripSopirData = listTrip.get(position);

        holder.tvId.setText("ID Trip: " +tripSopirData.getIdTrip());
        holder.tvAsal.setText(tripSopirData.getIdKotaAsal());
        holder.tvTujuan.setText(tripSopirData.getIdKotaTujuan());
        holder.tvJadwal.setText(tripSopirData.getTanggal());
        holder.tvJam.setText(tripSopirData.getJadwal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listTrip.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTrip.size();
    }

    public class TripHolder extends RecyclerView.ViewHolder {
        TextView tvAsal, tvTujuan, tvJadwal, tvJam, tvId;

        public TripHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_item_id_trip);
            tvAsal = itemView.findViewById(R.id.tv_item_asal);
            tvTujuan = itemView.findViewById(R.id.tv_item_tujuan);
            tvJadwal = itemView.findViewById(R.id.tv_item_jadwal);
            tvJam = itemView.findViewById(R.id.tv_item_jam);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TripSopirData data);
    }
}
