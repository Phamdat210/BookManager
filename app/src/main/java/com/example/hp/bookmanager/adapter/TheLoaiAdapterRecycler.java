package com.example.hp.bookmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.model.TheLoai;

import java.util.List;

public class TheLoaiAdapterRecycler extends RecyclerView.Adapter<TheLoaiAdapterRecycler.TheLoaiViewHolder> {

    private Context context;
    private List<TheLoai> arrTheLoai;
    private LayoutInflater inflater;

    public TheLoaiAdapterRecycler(Context context,List<TheLoai> arrTheLoai){
        this.context = context;
        this.arrTheLoai = arrTheLoai;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_the_loai,null);
        TheLoaiViewHolder viewHolder = new TheLoaiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder theLoaiViewHolder, int i) {
        TheLoai theLoai = arrTheLoai.get(i);
        theLoaiViewHolder.tvCateID.setText(theLoai.getCateID());
        theLoaiViewHolder.tvCateName.setText(theLoai.getCateName());
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
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
