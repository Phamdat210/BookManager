package com.example.hp.bookmanager.model;

public class Sach {
    private String bookID;
//    private String cateID;
    private String bookName;
    private String author;
    private String producer;
    private String price;
    private String number;

    public Sach(){

    }

    public Sach(String bookID, String bookName, String author, String producer, String price, String number) {
        this.bookID = bookID;
//        this.cateID = cateID;
        this.bookName = bookName;
        this.author = author;
        this.producer = producer;
        this.price = price;
        this.number = number;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

//    public String getCateID() {
//        return cateID;
//    }
//
//    public void setCateID(String cateID) {
//        this.cateID = cateID;
//    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
