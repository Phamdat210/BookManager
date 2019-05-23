package com.example.hp.bookmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.bookmanager.R;
import com.example.hp.bookmanager.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    public Activity context;
    public List<NguoiDung> arrNguoiDung;
    public LayoutInflater inflater;

    public NguoiDungAdapter(Activity context, List<NguoiDung> arrNguoiDung){
        super();
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nguoi_dung,null);
            holder.imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
            holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = convertView.findViewById(R.id.imgDelete);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        NguoiDung nguoiDung = arrNguoiDung.get(position);
        holder.tvName.setText(nguoiDung.getUsername());
        holder.tvPhone.setText(nguoiDung.getPhone());
        return convertView;
    }

    public static class ViewHolder{
        public ImageView imgIcon, imgDelete;
        public TextView tvName, tvPhone;

    }
}
