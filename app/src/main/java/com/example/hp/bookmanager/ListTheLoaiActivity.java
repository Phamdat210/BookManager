package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.hp.bookmanager.adapter.TheLoaiAdapter;
import com.example.hp.bookmanager.adapter.TheLoaiAdapterRecycler;
import com.example.hp.bookmanager.dao.TheLoaiDAO;
import com.example.hp.bookmanager.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {

    public static List<TheLoai> dsTheLoai = new ArrayList<>();
//    ListView lvTheLoai;
    TheLoaiDAO theLoaiDAO;
    TheLoaiAdapter adapter = null;
    RecyclerView recyclerView;
    TheLoaiAdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);

//        lvTheLoai = findViewById(R.id.lvTheLoai);
        recyclerView = findViewById(R.id.rvTheLoai);
        theLoaiDAO = new TheLoaiDAO(ListTheLoaiActivity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();

        adapterRecycler = new TheLoaiAdapterRecycler(ListTheLoaiActivity.this,dsTheLoai);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapterRecycler);
//        adapter = new TheLoaiAdapter(ListTheLoaiActivity.this,dsTheLoai);
//        lvTheLoai.setAdapter(adapter);
    }

    public void viewTheLoai(View view) {
        Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
        startActivity(intent);
        finish();
    }

}
