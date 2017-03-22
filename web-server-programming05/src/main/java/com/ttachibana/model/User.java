package com.ttachibana.model;

public class User
{
    private long UserID;
    private String Lname;
    private String Fname;
    private String password;
    private String email;
    private String phoneNumber;
    private String city;
    private String Gender;
    private String languages;

    public long getUserID() {return UserID;}
    public void setUserID(long UserID) {this.UserID = UserID;}
    public String getLname() {return Lname;}
    public void setLname(String Lname) {this.Lname = Lname;}
    public String getFname() {return Fname;}
    public void setFname(String Fname) {this.Fname = Fname;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getGender() {return Gender;}
    public void setGender(String Gender) {this.Gender = Gender;}
    public String getLanguages() {return languages;}
    public void setLanguages(String languages) {this.languages = languages;}
}
