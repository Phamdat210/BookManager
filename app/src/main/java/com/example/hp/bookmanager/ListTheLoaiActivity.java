package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListTheLoaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
    }

    public void viewTheLoai(View view) {
        Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
        startActivity(intent);
    }
}
