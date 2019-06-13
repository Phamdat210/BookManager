package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bookmanager.dao.NguoiDungDAO;

public class LoginActivity extends AppCompatActivity {
    private EditText edUser;
    private EditText edPass;
    NguoiDungDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = (EditText) findViewById(R.id.edUser);
        edPass = (EditText) findViewById(R.id.edPass);
    }

    public void checkLogin(View view) {
        String user = edUser.getText().toString();
        String pass = edPass.getText().toString();
        if (user.equals("dat99") || pass.equals("123")) {
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
        }


//        if(dao.checkLogin(edUser.getText().toString(),edPass.getText().toString())<=0){
//            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
//            Intent i=new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(i);
//        }
    }
}
