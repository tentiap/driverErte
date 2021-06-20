package com.example.drivererte.adapter.sopir;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivererte.R;
import com.example.drivererte.activity.sopir.ChangeStatusActivitySopirError;
import com.example.drivererte.model.detailTripSopir.DetailTripSopirData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class DetailTripSopirAdapter extends RecyclerView.Adapter<DetailTripSopirAdapter.DetailTripSopirHolder> {
    private Context ctx;
    private List<DetailTripSopirData> listDetailTripSopir;

    public DetailTripSopirAdapter(Context ctx, List<DetailTripSopirData> listDetailTripSopir) {
        this.ctx = ctx;
        this.listDetailTripSopir = listDetailTripSopir;
    }

    @NonNull
    @Override
    public DetailTripSopirHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_trip, parent, false);
        DetailTripSopirHolder holder = new DetailTripSopirHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final DetailTripSopirHolder holder, int position) {
        DetailTripSopirData detailTripSopirData = listDetailTripSopir.get(position);

        holder.tvPassengerName.setText(detailTripSopirData.getNamaPenumpang());
        holder.tvPassengerGender.setText(detailTripSopirData.getJenisKelamin());
        holder.tvPassengerAsal.setText(detailTripSopirData.getDetailAsal());
        holder.tvPassengerTujuan.setText(detailTripSopirData.getDetailTujuan());
        holder.tvPassengerSeat.setText(detailTripSopirData.getIdSeat());
        holder.tvPassengerStatus.setText(detailTripSopirData.getStatus());

        holder.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ctx, "You click button change", Toast.LENGTH_SHORT).show();
                Intent changeStatusSopir = new Intent(ctx, ChangeStatusActivitySopirError.class);
                changeStatusSopir.putExtra(ChangeStatusActivitySopirError.EXTRA_CHANGE_STATUS_SOPIR, detailTripSopirData);
                ctx.startActivity(changeStatusSopir);
            }
        });

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "You click button call ", Toast.LENGTH_SHORT).show();
                Uri phoneNumber = Uri.parse("tel:" + detailTripSopirData.getNoHp());
                Intent callPassenger = new Intent(Intent.ACTION_DIAL, phoneNumber);
                ctx.startActivity(callPassenger);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listDetailTripSopir.size();
    }

    public class DetailTripSopirHolder extends RecyclerView.ViewHolder {
        TextView tvPassengerName, tvPassengerGender, tvPassengerAsal, tvPassengerTujuan,
                 tvPassengerSeat, tvPassengerStatus;
        Button btnCall, btnChange;

        public DetailTripSopirHolder(@NonNull View itemView) {
            super(itemView);

            tvPassengerName = itemView.findViewById(R.id.tv_passenger_name);
            tvPassengerGender = itemView.findViewById(R.id.tv_passenger_gender);
            tvPassengerAsal = itemView.findViewById(R.id.tv_passenger_asal);
            tvPassengerTujuan = itemView.findViewById(R.id.tv_passenger_tujuan);
            tvPassengerSeat = itemView.findViewById(R.id.tv_passenger_seat);
            tvPassengerStatus = itemView.findViewById(R.id.tv_passenger_status);
            btnCall = itemView.findViewById(R.id.btn_call);
            btnChange = itemView.findViewById(R.id.btn_change);

//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
//                    dialogPesan.setMessage("Choose what to do");
//                    dialogPesan.setCancelable(true);
//
//                    dialogPesan.setPositiveButton("Call", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            callPassenger();
//                            dialog.dismiss();
//                        }
//                    });
//
//                    dialogPesan.setNegativeButton("Change Status", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            changeStatus();
//                            dialog.dismiss();
//
//                        }
//                    });
//
//                    dialogPesan.show();
//
//                    return false;
//                }
//            });


        }
    }

//    private void changeStatus() {
//        Toast.makeText(ctx, "You click button change", Toast.LENGTH_SHORT).show();
//
//    }
//
//    private void callPassenger() {
//        Toast.makeText(ctx, "You click button call ", Toast.LENGTH_SHORT).show();
//    }


}
