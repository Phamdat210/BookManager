package com.example.hp.bookmanager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.bookmanager.dao.HoaDonDAO;
import com.example.hp.bookmanager.model.HoaDon;

import java.util.Calendar;

public class HoaDonActivity extends AppCompatActivity {
    private EditText edBillID;
    private TextView edDate;
    private Button btnChon;
    private Button btnLuu;
    private Button btnUpdate;
    HoaDonDAO hoaDonDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        edBillID = (EditText) findViewById(R.id.edBillID);
        edDate = (TextView) findViewById(R.id.edDate);
        btnChon = (Button) findViewById(R.id.btnChon);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        try {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle bundle = intent.getBundleExtra("bundle");
                edBillID.setText(bundle.getString("billID"));
                edDate.setText(bundle.getString("date"));
            }
        } catch (Exception ex){

        }

        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Calendar calendar = Calendar.getInstance();
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                // thiet lap thong tin cho date picker
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        int n = year;
//                        int t = month;
//                        Integer d = dayOfMonth;
//                        edDate.setText(d.toString()+"-"+t.toString()+"-"+n.toString());
//                    }
//                }, year, month, day);
//
//                datePickerDialog.show();
                showDatePicker();
            }
        });
    }
    private void showDatePicker() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                edDate.setText(day +" - " + month + " - " + year);
            }
        }, year, month, day);
        datePicker.show();
    }

    public void addBill(View view) {
        hoaDonDAO = new HoaDonDAO(HoaDonActivity.this);
        HoaDon hoaDon = new HoaDon(edBillID.getText().toString(),
                edDate.getText().toString());
        if (hoaDonDAO.insertHoaDon(hoaDon)==1){
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(HoaDonActivity.this,ListHoaDonActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void updateBill(View view) {
        hoaDonDAO = new HoaDonDAO(HoaDonActivity.this);
        HoaDon hoaDon = new HoaDon(edBillID.getText().toString(),
                edDate.getText().toString());
        if (hoaDonDAO.updateHoaDon(hoaDon)==1){
            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(HoaDonActivity.this,ListHoaDonActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Cập nhật thất bại",Toast.LENGTH_LONG).show();
        }
    }
}
