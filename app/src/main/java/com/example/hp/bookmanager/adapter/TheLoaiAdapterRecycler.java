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


import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.TheLoaiActivity;
import com.example.hp.bookmanager.dao.TheLoaiDAO;
import com.example.hp.bookmanager.model.TheLoai;

import java.util.List;

public class TheLoaiAdapterRecycler extends RecyclerView.Adapter<TheLoaiAdapterRecycler.TheLoaiViewHolder> {

    private Context context;
    private List<TheLoai> arrTheLoai;
    private LayoutInflater inflater;
    TheLoaiDAO theLoaiDAO;

    public TheLoaiAdapterRecycler(Context context,List<TheLoai> arrTheLoai){
        this.context = context;
        this.arrTheLoai = arrTheLoai;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View view = inflater.inflate(R.layout.item_the_loai,null);
        TheLoaiViewHolder viewHolder = new TheLoaiViewHolder(view);
        viewHolder.imgIcon = view.findViewById(R.id.imgIcon);
        viewHolder.tvCateID = view.findViewById(R.id.tvCateID);
        viewHolder.tvCateName = view.findViewById(R.id.tvCateName);
        viewHolder.imgDelete = view.findViewById(R.id.imgDeleteCate);
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theLoaiDAO.delTheLoai(arrTheLoai.get(i).getCateID());
                TheLoai theLoai = arrTheLoai.get(i);
                arrTheLoai.remove(theLoai);
                notifyDataSetChanged();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder theLoaiViewHolder,final int i) {
        TheLoai theLoai = arrTheLoai.get(i);
        theLoaiViewHolder.tvCateID.setText(theLoai.getCateID());
        theLoaiViewHolder.tvCateName.setText(theLoai.getCateName());
        theLoaiViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheLoai theLoai1 = arrTheLoai.get(i);
                Intent intent = new Intent(context, TheLoaiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",theLoai1.getCateID());
                bundle.putString("name",theLoai1.getCateName());
                bundle.putString("location",theLoai1.getLocation());
                bundle.putString("description",theLoai1.getDescription());
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
                Toast.makeText(context,"Sửa",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrTheLoai.size();
    }

    public class TheLoaiViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgIcon, imgDelete;
        public TextView tvCateName, tvCateID;

        public TheLoaiViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvCateID = itemView.findViewById(R.id.tvCateID);
            tvCateName = itemView.findViewById(R.id.tvCateName);
            imgDelete = itemView.findViewById(R.id.imgDeleteCate);
        }
    }
}
