package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hp.bookmanager.adapter.SachAdapterRecycler;
import com.example.hp.bookmanager.dao.SachDAO;
import com.example.hp.bookmanager.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListSachActivity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    SachDAO sachDAO;
    RecyclerView recyclerView;
    SachAdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sach);

        recyclerView = findViewById(R.id.rvSach);
        sachDAO = new SachDAO(ListSachActivity.this);
        dsSach = sachDAO.getAllSach();

        adapterRecycler = new SachAdapterRecycler(ListSachActivity.this,dsSach);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapterRecycler);
    }

    public void viewSach(View view) {
        Intent i = new Intent(ListSachActivity.this,SachActivity.class);
        startActivity(i);
    }
}
