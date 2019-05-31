package com.example.hp.bookmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapterRecycler extends RecyclerView.Adapter<NguoiDungAdapterRecycler.NguoiDungViewHolder> {

    private Context context;
    private List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;

    public NguoiDungAdapterRecycler(Context context, List<NguoiDung> arrNguoiDung){
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//  Tạo View
    @Override
    public NguoiDungViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view1 = inflater.inflate(R.layout.item_nguoi_dung,null);
        NguoiDungViewHolder view = new NguoiDungViewHolder(view1);
        return view;
    }

//  Gán dữ liệu
    @Override
    public void onBindViewHolder(NguoiDungViewHolder nguoiDungViewHolder, int i) {
        NguoiDung nguoiDung =  arrNguoiDung.get(i);
        nguoiDungViewHolder.tvName.setText(nguoiDung.getUsername());
        nguoiDungViewHolder.tvPhone.setText(nguoiDung.getPhone());
    }

    @Override
    public int getItemCount() {
        return arrNguoiDung.size();
    }

    public class NguoiDungViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgIcon, imgDelete;
        public TextView tvName, tvPhone;

        public NguoiDungViewHolder( View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }

}
