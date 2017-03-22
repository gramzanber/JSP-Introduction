package com.ttachibana.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="shoppingCart")
@SessionScoped
public class ShoppingCart implements Serializable
{     
    private ArrayList<Book> cart;
    private double totalPrice = 0.0;
    
    public ShoppingCart(){this.cart = new ArrayList<>();}
    
    public void add(Book addingbook)
    {
        boolean found = false;
        for(Book book : cart)
        {
            if(book.getAuthor().equals(addingbook.getAuthor()))
            {
                found = true;
                book.setCount(book.getCount()+1);
                book.setPrice(book.getPrice()+addingbook.getUnitPrice());
                totalPrice = totalPrice + addingbook.getUnitPrice();
           }
        }
        if(!found)
        {
            cart.add(new Book(addingbook.getTitle(),addingbook.getAuthor(),addingbook.getUnitPrice(),addingbook.getUnitPrice(),1));
            totalPrice = totalPrice + addingbook.getUnitPrice();
        }    
    }
    
    public ArrayList<Book> getCart(){return cart;}
    public double getTotalPrice() {return totalPrice;}
    
    public void removeItem(Book removingBook)
    {
        for(Book book : cart)
        {
            if(book.getAuthor().equals(removingBook.getAuthor()))
            {
                book.setCount(book.getCount()-1);
                book.setPrice(book.getPrice()-book.getUnitPrice());
                totalPrice = totalPrice - book.getUnitPrice();
                if(totalPrice<0){totalPrice = 0.0;}
                if(book.getCount()==0)
                {
                    cart.remove(book);
                    break;
                }
            }
        }
    }
}
