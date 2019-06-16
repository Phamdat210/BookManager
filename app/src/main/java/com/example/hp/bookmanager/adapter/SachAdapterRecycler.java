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
import com.example.hp.bookmanager.SachActivity;
import com.example.hp.bookmanager.dao.SachDAO;
import com.example.hp.bookmanager.model.Sach;

import java.util.List;

public class SachAdapterRecycler extends RecyclerView.Adapter<SachAdapterRecycler.SachViewHolder>{

    private Context context;
    private List<Sach> arrSach;
    private LayoutInflater inflater;
    private SachDAO sachDAO;

    public SachAdapterRecycler(Context context, List<Sach> arrSach){
        this.context = context;
        this.arrSach = arrSach;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public SachViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View view1 = inflater.inflate(R.layout.item_sach,null);
        SachViewHolder view = new SachViewHolder(view1);
        view.imgIcon = view1.findViewById(R.id.imgIcon);
        view.tvBookName = view1.findViewById(R.id.tvBookName);
        view.tvNumber = view1.findViewById(R.id.tvNumber);
        view.imgDeleteBook = view1.findViewById(R.id.imgDeleteBook);
        view.imgDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sachDAO.deleteSach(arrSach.get(i).getBookID());
                Sach sach = arrSach.get(i);
                arrSach.remove(sach);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull SachViewHolder sachViewHolder,final int i) {
        Sach sach = arrSach.get(i);
        sachViewHolder.tvBookName.setText(sach.getBookID());
        sachViewHolder.tvNumber.setText(sach.getNumber());
        sachViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sach sach1 = arrSach.get(i);
                Intent intent = new Intent(context, SachActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("bookID",sach1.getBookID());
//                bundle.putString("cateID",sach1.getCateID());
                bundle.putString("bookName",sach1.getBookName());
                bundle.putString("author",sach1.getAuthor());
                bundle.putString("producer",sach1.getProducer());
                bundle.putString("price",sach1.getPrice());
                bundle.putString("number",sach1.getNumber());
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
                Toast.makeText(context,"Sửa",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrSach.size();
    }

    public class SachViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgIcon, imgDeleteBook;
        public TextView tvBookName, tvNumber;

        public SachViewHolder( View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvBookName = itemView.findViewById(R.id.tvBookName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            imgDeleteBook = itemView.findViewById(R.id.imgDeleteBook);
        }
    }
}
