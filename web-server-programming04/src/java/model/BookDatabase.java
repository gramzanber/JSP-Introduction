package model;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class BookDatabase implements Serializable
{
    
    private static final Book [] books = new Book[]
    {
        new Book("Intro to Java Servlets","Nguyen",10.95,0, 0),
        new Book("Intro to JSP","Cheng" ,11.95,0, 0),
        new Book("Intro to JSF","Sung" ,12.95,0, 0),
        new Book("Intro to Java EE","Tachibana" ,13.95,0, 0)
    };
    
    public Book[] getBooks(){return books;}
}
