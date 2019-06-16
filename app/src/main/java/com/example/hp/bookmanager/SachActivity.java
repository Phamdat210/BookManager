package com.example.hp.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.dao.SachDAO;
import com.example.hp.bookmanager.dao.TheLoaiDAO;
import com.example.hp.bookmanager.model.Sach;
import com.example.hp.bookmanager.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    List<String> list = new ArrayList<String>();
    private EditText edBookID;
    private EditText edBookName;
    private EditText edAuthor;
    private EditText edProducer;
    private EditText edPrice;
    private EditText edNumber;
    SachDAO sachDAO;
    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        edBookID = (EditText) findViewById(R.id.edBookID);
        edBookName = (EditText) findViewById(R.id.edBookName);
        edAuthor = (EditText) findViewById(R.id.edAuthor);
        edProducer = (EditText) findViewById(R.id.edProducer);
        edPrice = (EditText) findViewById(R.id.edPrice);
        edNumber = (EditText) findViewById(R.id.edNumber);
        spinner = findViewById(R.id.spTheLoai);

        try {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("bundle");
                edBookID.setText(bundle.getString("bookID"));
                edBookName.setText(bundle.getString("bookName"));
                edAuthor.setText(bundle.getString("author"));
                edProducer.setText(bundle.getString("producer"));
                edPrice.setText(bundle.getString("price"));
                edNumber.setText(bundle.getString("number"));
            }
        } catch (Exception ex){

        }

        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(getApplicationContext());
        list = theLoaiDAO.getAllMaTheLoai();
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = String.valueOf(parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addBook(View view) {
        sachDAO = new SachDAO(SachActivity.this);
        Sach sach = new Sach(edBookID.getText().toString(),
                edBookName.getText().toString(),
                edAuthor.getText().toString(),
                edProducer.getText().toString(),
                edPrice.getText().toString(),
                edNumber.getText().toString());
        if (sachDAO.insertSach(sach)==1){
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SachActivity.this,ListSachActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void updateBook(View view) {

    }
}
