package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bookmanager.adapter.NguoiDungAdapter;
import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    private EditText edUser;
    private EditText edPass;
    private EditText edRePass;
    private EditText edPhone;
    private EditText edFullName;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnListNguoiDung;
    NguoiDungDAO nguoiDungDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        edUser = (EditText) findViewById(R.id.edUser);
        edPass = (EditText) findViewById(R.id.edPass);
//        edRePass = (EditText) findViewById(R.id.edRePass);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edFullName = (EditText) findViewById(R.id.edFullName);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnListNguoiDung = (Button) findViewById(R.id.btnListNguoiDung);

        try {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("bundle");
                edUser.setText(bundle.getString("userName"));
                edPass.setText(bundle.getString("password"));
                edPhone.setText(bundle.getString("phone"));
                edFullName.setText(bundle.getString("fullname"));
            }
        } catch (Exception ex){

        }
    }

    public void addUser(View view) {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(),
                edPass.getText().toString(),
                edPhone.getText().toString(),
                edFullName.getText().toString());
        if (nguoiDungDAO.insertNguoiDung(nguoiDung)==1){
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(NguoiDungActivity.this,ListNguoiDungActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void userUpdate(View view) {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(),
                edPass.getText().toString(),
                edPhone.getText().toString(),
                edFullName.getText().toString());
        if (nguoiDungDAO.updateNguoiDung(nguoiDung)==1){
            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(NguoiDungActivity.this,ListNguoiDungActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Cập nhật thất bại",Toast.LENGTH_LONG).show();
        }
    }
}
