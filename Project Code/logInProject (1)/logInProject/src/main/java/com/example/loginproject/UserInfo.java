package com.example.loginproject;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private  String Book_title;
    private  String Book_id;
    private String Author;
    private String Date;
    private  String Genre;
    private  String  Price;
    public UserInfo(){
        this.Book_id = "";
        this.Book_title = "";
        this.Date="";
        this.Author="";
        this.Genre="";
        this.Price="";
    }

    public UserInfo(String book_idText, String book_titleText, String authorText, String genreText, String dateText, String priceText) {
        this.Book_id=book_idText;
        this.Book_title=book_titleText;
        this.Author=authorText;
        this.Genre=genreText;
        this.Date=dateText;
        this.Price=priceText;

    }
//    public UserInfo(String Book_id, String Book_title, String Author, String Genre, String Date, String Price) {
//        this.Book_id=Book_id;
//        this.Book_title=Book_title;
//        this.Author=Author;
//        this.Genre=Genre;
//        this.Date=Date;
//        this.Price=Price;
//    }
//    public  UserInfo(String userName, String password){
//        this.userName = userName;
//        this.password = password;
//    }

    public String getBook_title() {
        return Book_title;
    }

    public void setBook_title(String book_title) {
        Book_title = book_title;
    }

    public String getBook_id() {
        return Book_id;
    }

    public void setBook_id(String book_id) {
        Book_id = book_id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    public String toString(){
//        return "username: "+this.userName+" Password: "+this.password;
//    }
}
