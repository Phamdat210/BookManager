package com.example.hp.bookmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hp.bookmanager.database.DatabaseHelper;
import com.example.hp.bookmanager.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    public static final String SQL_HOA_DON = "CREATE TABLE HoaDon ("+
            " billID text primary key, "+
            " date text "+
            ");";
    public static final  String TABLE_NAME = "HoaDon";
    public HoaDonDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertHoaDon(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("billID",hoaDon.getBillID());
        values.put("date",hoaDon.getDate());

        try{
            if (db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("HoaDonDAO",ex.getMessage());
        }

        return 1;
    }

    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> ls = new ArrayList<HoaDon>();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            HoaDon hoaDon = new HoaDon();
            hoaDon.setBillID(cursor.getString(0));
            hoaDon.setDate(cursor.getString(1));
            ls.add(hoaDon);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
    public int deleteHoaDon(String billID){
        int result =  db.delete(TABLE_NAME,"billID=?",new String[]{billID});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int updateHoaDon(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("billID",hoaDon.getBillID());
        values.put("date",hoaDon.getDate());


        try{
            if (db.update(TABLE_NAME,values,"billID=?",new String[]{hoaDon.getBillID()})<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("HoaDonDAO",ex.getMessage());
        }

        return 1;
    }
}
