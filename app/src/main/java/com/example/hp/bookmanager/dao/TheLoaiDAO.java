package com.example.hp.bookmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hp.bookmanager.database.DatabaseHelper;
import com.example.hp.bookmanager.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai ("+
            " cateID text primary key, "+
            " cateName text, "+
            " location text, "+
            " description text, "+
    ");";

    public static final String TABLE_NAME = "TheLoai";
    public TheLoaiDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertTheLoai(TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("cateID",theLoai.getCateID());
        values.put("cateName",theLoai.getCateName());
        values.put("location",theLoai.getLocation());
        values.put("description",theLoai.getDescription());

        try{
            if (db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        } catch (Exception ex){
            Log.e("TheLoaiDAO",ex.getMessage());
        }
        return 1;
    }

    public List<TheLoai> getAllTheLoai(){
        List<TheLoai> ls = new ArrayList<TheLoai>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            TheLoai theLoai = new TheLoai();
            theLoai.setCateID(cursor.getString(0));
            theLoai.setCateName(cursor.getString(1));
            theLoai.setLocation(cursor.getString(2));
            theLoai.setDescription(cursor.getString(3));
            ls.add(theLoai);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }

}
