package com.example.hp.bookmanager.model;

public class Sach {
    private int bookID;
    private int cateID;
    private String bookName;
    private String author;
    private String producer;
    private int price;
    private int number;

    public Sach(int bookID, int cateID, String bookName, String author, String producer, int price, int number) {
        this.bookID = bookID;
        this.cateID = cateID;
        this.bookName = bookName;
        this.author = author;
        this.producer = producer;
        this.price = price;
        this.number = number;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
