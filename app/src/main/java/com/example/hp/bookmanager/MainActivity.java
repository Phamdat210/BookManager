package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgNguoiDung;
    private ImageView imgTheLoai;
    private ImageView imgSach;
    private ImageView imgHoaDon;
    private ImageView imgSachBan;
    private ImageView imgThongKe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgNguoiDung = (ImageView) findViewById(R.id.imgNguoiDung);
        imgTheLoai = (ImageView) findViewById(R.id.imgTheLoai);
        imgSach = (ImageView) findViewById(R.id.imgSach);
        imgHoaDon = (ImageView) findViewById(R.id.imgHoaDon);
        imgSachBan = (ImageView) findViewById(R.id.imgSachBan);
        imgThongKe = (ImageView) findViewById(R.id.imgThongKe);

        imgNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListNguoiDungActivity.class));
            }
        });

        imgTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListTheLoaiActivity.class));
            }
        });

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListSachActivity.class));
            }
        });

        imgHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListHoaDonActivity.class));
            }
        });

        imgSachBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SachBanChayActivity.class));
            }
        });

        imgThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThongKeActivity.class));
            }
        });

    }

}
