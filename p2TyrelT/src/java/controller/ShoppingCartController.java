package controller;

import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartController extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processLogin(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processLogin(request, response);
    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        ShoppingCartModel cart;
        String item;
        if(request.getParameter("item1") != null){item = "item1";}
        else if(request.getParameter("item2") != null){item = "item2";}
        else if(request.getParameter("item3") != null){item = "item3";}
        else if(request.getParameter("item4") != null){item = "item4";}
        else if(request.getParameter("item5") != null){item = "item5";}
        else{item = "Tyrel";}

        cart = (session.getAttribute("Cart") == null) ? new ShoppingCartModel() : (ShoppingCartModel)session.getAttribute("Cart");
        switch (item)
        {
            case "item1":
                cart.addItem("Laptop", 399.99);
                break;
            case "item2":
                cart.addItem("Generic PC", 399.99);
                break;
            case "item3":
                cart.addItem("Big Television", 499.99);
                break;
            case "item4":
                cart.addItem("Downward facing dog Tablet", 499.99);
                break;
            case "item5":
                cart.addItem("Oh so smart phone", 499.99);
                break;
            default:
                break;
        }
        session.setAttribute("Cart", cart);
        response.sendRedirect("Shopping_Cart");
    }
}
