package com.ttachibana.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Book
{
    @NotNull(message="Title cannot be blank")
    @Size(min = 3, max = 20, message="Title must 3 ~ 20 characters long")
    private String title;
    @NotNull(message="Author cannot be blank")
    @Size(min = 3, max = 20, message="Author must 3 ~ 20 characters long")
    private String author;
    @NotNull(message="Year cannot be blank")
    @Min(value=2000, message = "min publication year is 2000")
    @Max(value=2017, message = "max publication year is 2017")
    private int year;
    @NotNull(message="Price cannot be blank")
    @DecimalMax(value="300.00", message = "Too much, less than 300$")
    @DecimalMin(value="0.99", message = "Too little, more than 0.98$")
    @Digits(integer=3, fraction=2, message="max 3 digits integer and 2 digit fraction")
    private double price;
    private boolean editable;
    private int id;

    public boolean isEditable() {return editable;}
    public void setEditable(boolean editable) {this.editable = editable;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String Author) {this.author = Author;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
