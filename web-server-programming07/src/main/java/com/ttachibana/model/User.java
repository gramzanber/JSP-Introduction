package com.ttachibana.model;

public class User
{
    private String username;
    private String groups;
    private String email;
    
    public void setUsername(String u){this.username = u;}
    public void setGroups(String p){this.groups = p;}  
    public void setEmail(String e){this.email = e;}   
    public String getUsername(){return username;}   
    public String getGroups(){return groups;}    
    public String getEmail(){return email;}
}
