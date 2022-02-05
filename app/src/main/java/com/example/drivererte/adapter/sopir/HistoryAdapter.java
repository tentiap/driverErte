package com.example.drivererte.adapter.sopir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drivererte.R;
import com.example.drivererte.model.historySopir.HistorySopir;
import com.example.drivererte.model.historySopir.HistorySopirData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private Context ctx;
    private List<HistorySopirData> listHistory;

    public HistoryAdapter(Context ctx, List<HistorySopirData> listHistory) {
        this.ctx = ctx;
        this.listHistory = listHistory;
    }

    private HistoryAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(HistoryAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_history, parent, false);
        HistoryHolder holder = new HistoryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
//        HistorySopirData historySopirData = listHistory.get(position);
//
//        holder.tvId.setText("ID Trip: " +historySopirData.getIdTrip());
//        holder.tvAsal.setText(historySopirData.getIdKotaAsal());
//        holder.tvTujuan.setText(historySopirData.getIdKotaTujuan());
//        holder.tvJadwal.setText(historySopirData.getTanggal());
//        holder.tvJam.setText(historySopirData.getJadwal());
//
//       holder.itemView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));
//           }
//       });

        HistorySopirData historySopirData = listHistory.get(position);

//        holder.tvId.setText("ID Trip: " + historySopirData.getIdTrip());
        holder.tvId.setText(historySopirData.getPlatMobil());
        holder.tvAsal.setText(historySopirData.getIdKotaAsal());
        holder.tvTujuan.setText(historySopirData.getIdKotaTujuan());
        holder.tvJadwal.setText(historySopirData.getTanggal());
        holder.tvJam.setText(historySopirData.getJadwal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        TextView tvAsal, tvTujuan, tvJadwal, tvJam, tvId;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_item_id_trip_history);
            tvAsal = itemView.findViewById(R.id.tv_item_asal_history);
            tvTujuan = itemView.findViewById(R.id.tv_item_tujuan_history);
            tvJadwal = itemView.findViewById(R.id.tv_item_jadwal_history);
            tvJam = itemView.findViewById(R.id.tv_item_jam_history);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(HistorySopirData data);
    }

}
