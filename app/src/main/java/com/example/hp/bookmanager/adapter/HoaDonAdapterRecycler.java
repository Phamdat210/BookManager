package com.example.hp.bookmanager.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.bookmanager.HoaDonActivity;
import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.dao.HoaDonDAO;
import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.model.HoaDon;

import java.util.List;

public class HoaDonAdapterRecycler extends RecyclerView.Adapter<HoaDonAdapterRecycler.HoaDonViewHolder> {
    public Context context;
    public List<HoaDon> arrHoaDon;
    public LayoutInflater inflater;
    HoaDonDAO hoaDonDAO;

    public HoaDonAdapterRecycler(Context context, List<HoaDon> arrHoaDon){
        this.context = context;
        this.arrHoaDon = arrHoaDon;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public HoaDonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View view1 = inflater.inflate(R.layout.item_hoa_don,null);
        HoaDonViewHolder view = new HoaDonViewHolder(view1);
        view.imgIcon = view1.findViewById(R.id.imgIcon);
        view.tvBillID = view1.findViewById(R.id.tvBillID);
        view.tvDate = view1.findViewById(R.id.tvDate);
        view.imgDelete = view1.findViewById(R.id.imgDeleteBill);
        view.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoaDonDAO.deleteHoaDon(arrHoaDon.get(i).getBillID());
                HoaDon hoaDon = arrHoaDon.get(i);
                arrHoaDon.remove(hoaDon);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void onBindViewHolder(HoaDonViewHolder hoaDonViewHolder,final int i) {
        final HoaDon hoaDon = arrHoaDon.get(i);
        hoaDonViewHolder.tvBillID.setText(hoaDon.getBillID());
        hoaDonViewHolder.tvDate.setText(hoaDon.getDate());
        hoaDonViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoaDon hoaDon1 = arrHoaDon.get(i);
                Intent intent = new Intent(context, HoaDonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("billID",hoaDon1.getBillID());
                bundle.putString("password",hoaDon1.getDate());
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
                Toast.makeText(context,"Sửa",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrHoaDon.size();
    }

    public class HoaDonViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgIcon, imgDelete;
        public TextView tvBillID, tvDate;

        public HoaDonViewHolder( View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvBillID = itemView.findViewById(R.id.tvBillID);
            tvDate = itemView.findViewById(R.id.tvDate);
            imgDelete = itemView.findViewById(R.id.imgDeleteBill);
        }
    }
}
