package com.entity;

public class Book {
    private Integer bookid;
    private Integer sales;
    private Integer stock;
    private String bookname;
    private String author;
    private String img_path;
    private Double price;

    public Book() {
    }

    public Book(Integer bookid, Integer sales, Integer stock, String bookname, String author, String img_path, Double price) {
        this.bookid = bookid;
        this.sales = sales;
        this.stock = stock;
        this.bookname = bookname;
        this.author = author;
        this.img_path = img_path;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", sales=" + sales +
                ", stock=" + stock +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", img_path='" + img_path + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
