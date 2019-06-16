package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hp.bookmanager.adapter.HoaDonAdapterRecycler;
import com.example.hp.bookmanager.dao.HoaDonDAO;
import com.example.hp.bookmanager.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class ListHoaDonActivity extends AppCompatActivity {
    public static List<HoaDon> dsHoaDon = new ArrayList<>();
    //    ListView lvNguoiDung;
    HoaDonDAO hoaDonDAO;
    RecyclerView recyclerView;
    HoaDonAdapterRecycler adapterRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don);

        recyclerView = findViewById(R.id.recyclerview);
        hoaDonDAO = new HoaDonDAO(ListHoaDonActivity.this);
        dsHoaDon = hoaDonDAO.getAllHoaDon();

        adapterRecycler = new HoaDonAdapterRecycler(ListHoaDonActivity.this,dsHoaDon);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapterRecycler);
    }

    public void viewHoaDon(View view) {
        Intent i = new Intent(this,HoaDonActivity.class);
        startActivity(i);
    }
}
