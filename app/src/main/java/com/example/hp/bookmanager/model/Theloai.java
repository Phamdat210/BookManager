package com.example.hp.bookmanager.model;

public class Theloai {
    private int cateID;
    private String cateName;
    private String location;
    private String desciption;

    public Theloai(int cateID, String cateName, String location, String desciption) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.location = location;
        this.desciption = desciption;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return getCateID()+" | "+getCateName();
    }
}
