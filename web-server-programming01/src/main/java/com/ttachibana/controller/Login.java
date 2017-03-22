package com.ttachibana.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processLogin(request, response);
    }

    private void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        String username = (request.getParameter("username") != null) ? ((String)request.getParameter("username")).toLowerCase() : "";
        String password = (request.getParameter("password") != null) ? (String)request.getParameter("password") : "";
        
        if(!password.equals("secret") || password.equals(""))
        {
            session.setAttribute("Error", "Password was incorrect!");
            response.sendRedirect("Failed_Login");
        }
        else
        {
            switch (username)
            {
                case "sung":
                    response.sendRedirect("http://cs3.uco.edu/Hong/");
                    break;
                case "cs":
                    response.sendRedirect("http://cs.uco.edu/www/");
                    break;
                case "tyrel":
                    response.sendRedirect("http://www.ttachibana.com/");
                    break;
                default:
                    session.setAttribute("Error", "Username was wrong!");
                    response.sendRedirect("Failed_Login");
                    break;
            }
        }
    }
}
