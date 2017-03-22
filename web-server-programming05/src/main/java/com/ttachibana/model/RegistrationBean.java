package com.ttachibana.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@SessionScoped
public class RegistrationBean implements Serializable
{
    // resource injection
    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private String city;
    private String gender;
    private List<SelectItem> languages;
    private String greeting;
    private String error;

    public RegistrationBean()
    {
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.email = null;
        this.phoneNumber = null;
        this.city = null;
        this.gender = null;
        this.languages = null;
    }

    public static boolean isNumeric(String str)
    {
        for (int i = str.length();--i>=0;)    
            if (!Character.isDigit(str.charAt(i)))
                return false;
        return true;  
    }  
    
    public String showInfo() throws SQLException
    {
        if (ds == null){throw new SQLException("Cannot get DataSource");}

        Connection conn = ds.getConnection();
        if (conn == null) {throw new SQLException("Cannot get connection");}
        
        error = "";
        
        if (lastName.trim().isEmpty())
        {
            error = error + "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please input your last name", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:lastName", facesMsg);    
        }
        else if(isNumeric(lastName))
        {
            error = error + "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alphabet only", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:lastName", facesMsg);   
        }
        
        if (firstName.trim().isEmpty())
        {
            error = error + "(firstName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please input your first name", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:firstName", facesMsg);    
        }
        else if(isNumeric(firstName))
        {
            error = error + "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alphabet only", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:firstName", facesMsg);   
        }  
        
        if (password.trim().isEmpty())
        {
            error = error + "(password)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please type in your password", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:password", facesMsg);    
        }
        else if(password.length()<4)
        {
            error = error + "(password)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password should at least 4 chars", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:password", facesMsg);
        }

        if (email.trim().isEmpty())
        {
            error = error + "(email)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "type in your email address", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:email", facesMsg);    
        }
        else if(!(email.contains("@")))
        {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please input a valid email address", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:email", facesMsg);    
        }

        if (phoneNumber.trim().isEmpty())
        {
            error = error + "(phoneNumber)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "type in your Phone#", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:phoneNumber", facesMsg);    
        }
        else if(!(phoneNumber.contains("-")))
        {
            error += "(phoneNumber)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please type in # in this format: ###-###-####", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:phoneNumber", facesMsg);    
        }

        if (gender == null)
        {
            error = error + " (gender)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose your gender", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:Gender", facesMsg);    
        }
        
        if (city.equals("-- choose --"))
        {
            error = error + " (city)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose your city", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:City", facesMsg); 
        }
        
        if (languages.isEmpty())
        {
            error = error + "(languages)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose at least one languages", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:Languages", facesMsg);    
        }
        
        if (!error.isEmpty())
            return null;

        try
        {
            PreparedStatement pst = conn.prepareStatement("Insert into customer (LNAME,FNAME,PASSWORD,EMAIL,PHONE,HOMETOWN,GENDER,LANGUAGES) values (?,?,?,?,?,?,?,?)");
            pst.setString(1, lastName);
            pst.setString(2, firstName);
            pst.setString(3, password);
            pst.setString(4, email);
            pst.setString(5, phoneNumber);
            pst.setString(6, city);
            pst.setString(7, gender);
            String newLanguages = languages.toString();
            pst.setString(8, newLanguages);
            pst.executeUpdate();
        }
        catch(Exception getUsersException){throw new SQLException("Error: " + getUsersException.getMessage());}
        finally{conn.close();}
            
        if (gender.equals("male"))
            greeting = "Mr.";
        else
            greeting = "Ms.";
        return "showinformation";
    }

    public List<User> getUsers() throws SQLException
    {
        if (ds == null){throw new SQLException("Cannot get DataSource");}

        Connection conn = ds.getConnection();
        if (conn == null) {throw new SQLException("Cannot get connection");}
        
        List<User> list = new ArrayList<>();

        try
        {
            PreparedStatement ps = conn.prepareStatement("select LNAME, FNAME, EMAIL, PHONE, HOMETOWN, GENDER, LANGUAGES from CUSTOMER");

            // retrieve customer data from database
            ResultSet result = ps.executeQuery();

            while (result.next())
            {
                User u = new User();
                u.setLname(result.getString("LNAME"));
                u.setFname(result.getString("FNAME"));
                u.setEmail(result.getString("EMAIL"));
                u.setPhoneNumber(result.getString("PHONE"));
                u.setCity(result.getString("HOMETOWN"));
                u.setGender(result.getString("GENDER"));
                u.setLanguages(result.getString("LANGUAGES"));
                list.add(u);
            }
        }
        catch(Exception showInfoException){throw new SQLException("Error: " + showInfoException.getMessage());}
        finally{conn.close();}
        
        return list;
    }
    
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public List<SelectItem> getAvailableCities() {return Utility.cityList();}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public List<SelectItem> getLanguages() {return languages;}
    public void setLanguages(List<SelectItem> languages) {this.languages = languages;}
    public List<SelectItem> getLanguageItems() {return Utility.languageList();}
    public String getGreeting() {return greeting;}
    public String getError() {return error;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
