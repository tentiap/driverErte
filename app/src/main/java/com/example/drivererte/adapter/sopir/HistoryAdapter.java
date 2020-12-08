package com.example.drivererte.adapter.sopir;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

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

    private TripAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(TripAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
