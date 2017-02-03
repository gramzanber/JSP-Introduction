package model;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@SessionScoped
public class RegistrationBean implements Serializable
{
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
        {
           if (!Character.isDigit(str.charAt(i))){return false;}  
        }  
        return true;  
    }  
    
    public String showInfo()
    {
        error = "";
        if (lastName.trim().isEmpty())
        {
            error += "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please input your last name", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:lastName", facesMsg);    
        }
        else if(isNumeric(lastName))
        {
            error += "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alphabet only", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:lastName", facesMsg);   
        }
        
        if (firstName.trim().isEmpty())
        {
            error += "(firstName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please input your first name", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:firstName", facesMsg);    
        }
        else if(isNumeric(firstName))
        {
            error += "(lastName)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alphabet only", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:firstName", facesMsg);   
        }  
        
        if (password.trim().isEmpty())
        {
            error += "(password)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please type in your password", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:password", facesMsg);    
        }
        else if(password.length()<4)
        {
            error += "(password)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password should at least 4 chars", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:password", facesMsg);
        }

        if (email.trim().isEmpty())
        {
            error += "(email)";
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
            error += "(phoneNumber)";
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
            error +=" (gender)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose your gender", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:Gender", facesMsg);    
        }
        
        if (city.equals("-- choose --"))
        {
            error += " (city)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose your city", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:City", facesMsg); 
        }
        
        if (languages.isEmpty())
        {
            error += "(languages)";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "please choose at least one languages", null);
            FacesContext.getCurrentInstance().addMessage("registrationform:Languages", facesMsg);    
        }
        
        if (!error.isEmpty())
            return null;
        
        if (gender.equals("male"))
            greeting = "Mr.";
        else
            greeting = "Ms.";
        return "showinformation";
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
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
    public String getGreeting() {return (greeting == null) ? "Guest" : greeting;}
    public String getError() {return error;}
}
