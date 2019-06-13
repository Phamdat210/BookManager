package com.example.hp.bookmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hp.bookmanager.database.DatabaseHelper;
import com.example.hp.bookmanager.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung ("+
                " username text primary key, "+
                " password text, "+
                " phone text, "+
                " fullname text"+
    ");";
    public static final  String TABLE_NAME = "NguoiDung";
    public NguoiDungDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung nguoiDung){
        ContentValues values = new ContentValues();
        values.put("username",nguoiDung.getUsername());
        values.put("password",nguoiDung.getPassword());
        values.put("phone",nguoiDung.getPhone());
        values.put("fullname",nguoiDung.getFullname());

        try{
            if (db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("NguoiDungDAO",ex.getMessage());
        }

        return 1;
    }

    public List<NguoiDung> getAllNguoiDung(){
        List<NguoiDung> ls = new ArrayList<NguoiDung>();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setUsername(cursor.getString(0));
            nguoiDung.setPassword(cursor.getString(1));
            nguoiDung.setPhone(cursor.getString(2));
            nguoiDung.setFullname(cursor.getString(3));
            ls.add(nguoiDung);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
    public int deleteNguoiDung(String username){
        int result =  db.delete(TABLE_NAME,"username=?",new String[]{username});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int updateNguoiDung(NguoiDung nguoiDung){
        ContentValues values = new ContentValues();
        values.put("username",nguoiDung.getUsername());
        values.put("password",nguoiDung.getPassword());
        values.put("phone",nguoiDung.getPhone());
        values.put("fullname",nguoiDung.getFullname());

        try{
            if (db.update(TABLE_NAME,values,"username=?",new String[]{nguoiDung.getUsername()})<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("NguoiDungDAO",ex.getMessage());
        }

        return 1;
    }

    public int checkLogin(String usern,String passw){
        Cursor cursor= db.query(TABLE_NAME,null,"username=? and password=?",
                new String[]{usern,passw},null,null,null);
        int i= cursor.getCount();
        if (i==1){
            return 1;//login successful
        }
        return -1;//login failed
    }
}
