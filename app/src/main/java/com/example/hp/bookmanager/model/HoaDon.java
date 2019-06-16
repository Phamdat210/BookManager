package com.example.hp.bookmanager.model;

public class HoaDon {
    String billID;
    String date;

    public HoaDon(){

    }

    public HoaDon(String billID, String date) {
        this.billID = billID;
        this.date = date;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
