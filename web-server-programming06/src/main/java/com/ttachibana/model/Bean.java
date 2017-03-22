package com.ttachibana.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class Bean implements Serializable
{
     // resource injection
    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private ArrayList<Book> books;
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

    // Set default amounts to the minimum values allowed
    Bean()
    {
        price = 0.99;
        year = 2000;
    }
    
    @PostConstruct
    public void init()
    {
        try{books = getBookList();}
        catch (SQLException ex) {Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);}
    }

    public ArrayList<Book> getBookList() throws SQLException
    {
        if (ds == null){throw new SQLException("ds is null; Can't get data source");}
        Connection conn = ds.getConnection();
        if (conn == null) {throw new SQLException("conn is null; Can't get db connection");}

        ArrayList<Book> list = new ArrayList<>();
        
        try
        {
            PreparedStatement ps = conn.prepareStatement("select BOOK_ID,TITLE,AUTHOR,PUBLICATION_YEAR,PRICE  from BOOKDATABASE");

            // retrieve customer data from database
            ResultSet result = ps.executeQuery();

            while (result.next())
            {
                Book b = new Book();
                b.setId(result.getInt("BOOK_ID"));
                b.setTitle(result.getString("TITLE"));
                b.setAuthor(result.getString("Author"));
                b.setYear(result.getInt("PUBLICATION_YEAR"));
                b.setPrice(result.getDouble("PRICE"));
                list.add(b);
            }

        }
        finally {conn.close();}
        
        return list;   
    }

    public void insert() throws SQLException
    {
        if (ds == null){throw new SQLException("Cannot get DataSource");}
        Connection conn = ds.getConnection();
        if (conn == null){throw new SQLException("Cannot get connection");}
        
        try
        {
            Book b = new Book();
            PreparedStatement pst = conn.prepareStatement("Insert into bookdatabase(TITLE,AUTHOR,PUBLICATION_YEAR,PRICE)values (?,?,?,?)");
            pst.setString(1, title);
            b.setTitle(title);
            pst.setString(2, author);
            b.setAuthor(author);
            pst.setInt(3, year);
            b.setYear(year);
            pst.setDouble(4, price);
            b.setPrice(price);
            books.add(b);
            pst.executeUpdate();
        }
        finally{conn.close();}
        // THIS WAS VERY IMPORTANT!!! RE-SETS THE VALUES IN THE TABLE ON REFRESH
        this.init();
    }

    //delete move
    public void delete(Book b) throws SQLException
    {
        if (ds == null){throw new SQLException("Cannot get DataSource");}
        Connection conn = ds.getConnection();
        if (conn == null){throw new SQLException("Cannot get connection");}
        
        try
        {
            PreparedStatement pst1 = conn.prepareStatement("DELETE FROM bookdatabase where BOOK_ID = ?"); 
            pst1.setInt(1,b.getId());
            books.remove(b);
            pst1.executeUpdate();
        }
        finally{conn.close();}           
    }
    
    public String save(Book b) throws SQLException
    {
        if (ds == null){throw new SQLException("ds is null; Can't get data source");}
        Connection conn = ds.getConnection();
        if (conn == null) {throw new SQLException("conn is null; Can't get db connection");}
        
        String sql = "update bookdatabase set TITLE = ?, AUTHOR = ?, PUBLICATION_YEAR = ?, PRICE = ? where  BOOK_ID= ?";
        
        try
        {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setInt(3, b.getYear());
            ps.setDouble(4, b.getPrice());
            ps.setInt(5, b.getId());
            ps.executeUpdate();

        }
        finally{conn.close();}
        
        books.stream().forEach((Book bk) -> {bk.setEditable(false);});
        return null;
    }

    public ArrayList<Book> getBooks()  {return books;}
    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
}
