package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.hp.bookmanager.adapter.NguoiDungAdapter;
import com.example.hp.bookmanager.adapter.NguoiDungAdapterRecycler;
import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
//    ListView lvNguoiDung;
    NguoiDungDAO nguoiDungDAO;
    NguoiDungAdapter adapter=null;
    RecyclerView recyclerView;
    NguoiDungAdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
//        lvNguoiDung = findViewById(R.id.lvNguoiDung);
        recyclerView = findViewById(R.id.recyclerview);
        nguoiDungDAO = new NguoiDungDAO(ListNguoiDungActivity.this);
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();

        adapterRecycler = new NguoiDungAdapterRecycler(ListNguoiDungActivity.this,dsNguoiDung);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapterRecycler);

//        adapter = new NguoiDungAdapter(ListNguoiDungActivity.this,dsNguoiDung);
//        lvNguoiDung.setAdapter(adapter);

    }

    public void viewNguoiDung(View view) {
        Intent intent = new Intent(ListNguoiDungActivity.this, NguoiDungActivity.class);
        startActivity(intent);
        finish();
    }
}
