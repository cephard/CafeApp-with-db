package com.example.cafesystem.Controllers;

import com.example.cafesystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginController extends UIController {


    public TextField UserNameField;
    public PasswordField passwordField;
    public Text signUpText;
    public Button backButton;
    public Button resultButton;
    public Text loginStatus;
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

    @FXML
    public void switchToSignUp() throws IOException {
        UIController.setRoot("/signup");
    }
}
