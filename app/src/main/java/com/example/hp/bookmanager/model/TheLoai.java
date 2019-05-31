package com.example.hp.bookmanager.model;

public class TheLoai {
    private String cateID;
    private String cateName;
    private String location;
    private String description;

    public TheLoai(){

    }

    public TheLoai(String cateID, String cateName, String location, String desciption) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.location = location;
        this.description = desciption;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getCateID()+" | "+getCateName();
    }
}
