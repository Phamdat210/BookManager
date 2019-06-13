package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.bookmanager.dao.TheLoaiDAO;
import com.example.hp.bookmanager.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    private EditText edCateID;
    private EditText edCateName;
    private EditText edLocation;
    private EditText edDescription;
    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);

        edCateID = (EditText) findViewById(R.id.edCateID);
        edCateName = (EditText) findViewById(R.id.edCateName);
        edLocation = (EditText) findViewById(R.id.edLocation);
        edDescription = (EditText) findViewById(R.id.edDescription);

        try {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("bundle");
                edCateID.setText(bundle.getString("id"));
                edCateName.setText(bundle.getString("name"));
                edLocation.setText(bundle.getString("location"));
                edDescription.setText(bundle.getString("description"));
            }
        } catch (Exception ex){

        }

    }

    public void addCate(View view) {
        theLoaiDAO = new TheLoaiDAO(TheLoaiActivity.this);
        TheLoai theLoai = new TheLoai(edCateID.getText().toString(),
                edCateName.getText().toString(),
                edLocation.getText().toString(),
                edDescription.getText().toString());
        if (theLoaiDAO.insertTheLoai(theLoai)==1){
            Toast.makeText(TheLoaiActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TheLoaiActivity.this,ListTheLoaiActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(TheLoaiActivity.this,"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void cateUpdate(View view) {
        theLoaiDAO = new TheLoaiDAO(TheLoaiActivity.this);
        TheLoai theLoai = new TheLoai(edCateID.getText().toString(),
                edCateName.getText().toString(),
                edLocation.getText().toString(),
                edDescription.getText().toString());
        if (theLoaiDAO.updateTheLoai(theLoai)==1){
            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(TheLoaiActivity.this,ListTheLoaiActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Cập nhật thất bại",Toast.LENGTH_LONG).show();
        }
    }
}
