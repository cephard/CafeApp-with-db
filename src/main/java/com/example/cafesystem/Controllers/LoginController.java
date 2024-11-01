package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.SqlQueries;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends UIController {

    @FXML private TextField UserNameField;
    @FXML private PasswordField passwordField;
    @FXML private Button backButton;
    @FXML private Button resultButton;

    @FXML
    public void switchToSignUp() throws IOException {
        UIController.setRoot("/signup");
    }
@FXML public void retrieveUser(){
        SqlQueries sqlQueries = new SqlQueries();
        sqlQueries.readRecord("Customers", "first_name", UserNameField.getText());
    }
}
