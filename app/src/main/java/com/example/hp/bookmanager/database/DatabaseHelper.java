package com.example.hp.bookmanager.database;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.bookmanager.dao.NguoiDungDAO;
import com.example.hp.bookmanager.dao.SachDAO;
import com.example.hp.bookmanager.dao.TheLoaiDAO;
import com.example.hp.bookmanager.model.NguoiDung;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NguoiDungDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TheLoaiDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SachDAO.TABLE_NAME);
    }
}
