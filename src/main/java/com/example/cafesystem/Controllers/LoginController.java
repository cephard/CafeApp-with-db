package com.example.cafesystem.Controllers;

import javafx.fxml.FXML;

public class LoginController {



    private String userName;
    private String password;

    public void setUserName(String name){
        this.userName = name;
    }

    public String getUserName(){
        return userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
