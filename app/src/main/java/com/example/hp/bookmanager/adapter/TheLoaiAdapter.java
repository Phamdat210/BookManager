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
import com.example.hp.bookmanager.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {

    public Activity context;
    public List<TheLoai> arrTheLoai;
    public LayoutInflater inflater;

    public TheLoaiAdapter(Activity context, List<TheLoai> arrTheLoai){
        super();
        this.context = context;
        this.arrTheLoai = arrTheLoai;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrTheLoai.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTheLoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TheLoaiAdapter.ViewHolder holder;
        if (convertView == null){
            holder = new TheLoaiAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_the_loai,null);
            holder.imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
            holder.tvCateID = (TextView)convertView.findViewById(R.id.tvCateID);
            holder.tvCateName = convertView.findViewById(R.id.tvCateName);
            holder.imgDelete = convertView.findViewById(R.id.imgDelete);

            convertView.setTag(holder);
        } else {
            holder = (TheLoaiAdapter.ViewHolder)convertView.getTag();
        }

        TheLoai theLoai = arrTheLoai.get(position);
        holder.tvCateID.setText(theLoai.getCateID());
        holder.tvCateName.setText(theLoai.getCateName());
        return convertView;
    }

    public static class ViewHolder{
        public ImageView imgIcon, imgDelete;
        public TextView tvCateName, tvCateID;

    }
}
