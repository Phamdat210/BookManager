package com.example.hp.bookmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.bookmanager.NguoiDungActivity;
import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapterRecycler extends RecyclerView.Adapter<NguoiDungAdapterRecycler.NguoiDungViewHolder> {

    private Context context;
    private List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;
    private NguoiDungDAO nguoiDungDAO;

    public NguoiDungAdapterRecycler(Context context, List<NguoiDung> arrNguoiDung){
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoiDungDAO(context);
    }

//  Tạo View
    @Override
    public NguoiDungViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        View view1 = inflater.inflate(R.layout.item_nguoi_dung,null);
        NguoiDungViewHolder view = new NguoiDungViewHolder(view1);
        view.imgIcon = view1.findViewById(R.id.imgIcon);
        view.tvName = view1.findViewById(R.id.tvName);
        view.tvPhone = view1.findViewById(R.id.tvPhone);
        view.imgDelete = view1.findViewById(R.id.imgDelete);
        view.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nguoiDungDAO.deleteNguoiDung(arrNguoiDung.get(i).getUsername());
                NguoiDung nguoiDung = arrNguoiDung.get(i);
                arrNguoiDung.remove(nguoiDung);
                notifyDataSetChanged();
            }
        });
        return view;
    }

//  Gán dữ liệu
    @Override
    public void onBindViewHolder(NguoiDungViewHolder nguoiDungViewHolder,final int i) {
        NguoiDung nguoiDung = arrNguoiDung.get(i);
        nguoiDungViewHolder.tvName.setText(nguoiDung.getUsername());
        nguoiDungViewHolder.tvPhone.setText(nguoiDung.getPhone());
        nguoiDungViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NguoiDung nguoiDung1 = arrNguoiDung.get(i);
                Intent intent = new Intent(context, NguoiDungActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userName",nguoiDung1.getUsername());
                bundle.putString("password",nguoiDung1.getPassword());
                bundle.putString("phone",nguoiDung1.getPhone());
                bundle.putString("fullname",nguoiDung1.getFullname());
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
                Toast.makeText(context,"Sửa",Toast.LENGTH_SHORT).show();
            }
        });
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
