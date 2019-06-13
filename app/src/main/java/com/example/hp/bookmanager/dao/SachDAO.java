package com.example.hp.bookmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hp.bookmanager.database.DatabaseHelper;
import com.example.hp.bookmanager.model.NguoiDung;
import com.example.hp.bookmanager.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    public static final String SQL_SACH = "CREATE TABLE Sach ("+
            " bookID text primary key, "+
            " bookName text, "+
            " author text, "+
            " producer text, "+
            " price text, "+
            " number text "+
            ");";
    public static final  String TABLE_NAME = "Sach";
    public SachDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertSach(Sach sach){
        ContentValues values = new ContentValues();
        values.put("bookID",sach.getBookID());
        values.put("bookName",sach.getBookName());
        values.put("author",sach.getAuthor());
        values.put("producer",sach.getAuthor());
        values.put("price",sach.getPrice());
        values.put("number",sach.getNumber());

        try{
            if (db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("SachDAO",ex.getMessage());
        }

        return 1;
    }

    public List<Sach> getAllSach(){
        List<Sach> ls = new ArrayList<Sach>();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Sach sach = new Sach();
            sach.setBookID(cursor.getString(0));
            sach.setBookName(cursor.getString(1));
            sach.setAuthor(cursor.getString(2));
            sach.setProducer(cursor.getString(3));
            sach.setPrice(cursor.getString(4));
            sach.setNumber(cursor.getString(5));
            ls.add(sach);
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
    public int deleteSach(String id){
        int result =  db.delete(TABLE_NAME,"bookID=?",new String[]{id});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int updateSach(Sach sach){
        ContentValues values = new ContentValues();
        values.put("bookID",sach.getBookID());
//        values.put("cateID",sach.getCateID());
        values.put("bookName",sach.getBookName());
        values.put("author",sach.getAuthor());
        values.put("producer",sach.getAuthor());
        values.put("price",sach.getPrice());
        values.put("number",sach.getNumber());

        try{
            if (db.update(TABLE_NAME,values,"bookID=?",new String[]{sach.getBookID()})<0){
                return -1;
            }
        }catch (Exception ex){
            Log.e("SachDAO",ex.getMessage());
        }

        return 1;
    }

}
