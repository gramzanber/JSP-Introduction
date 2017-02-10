package model;

import java.io.Serializable;

public class Book implements Serializable
{
    private String title;
    private String author;
    private double unitPrice;
    private double price;
    private int count;

    public Book(String title, String author, double unitPrice, double price, int count)
    {
        this.title = title;
        this.author = author;
        this.unitPrice= unitPrice;
        this.price = price;
        this.count = count;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public double getUnitPrice() {return unitPrice;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
}
