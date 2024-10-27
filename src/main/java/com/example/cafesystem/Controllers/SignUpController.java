package com.example.cafesystem.Controllers;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController extends UIController {

    public TextField firstNameField;
    public TextField emailField;
    public TextField dataOfBirthField;
    public TextField phoneNumberField;
    public TextField passwordField;
    public TextField lastNameField;
    public TextField addressField;
    public PasswordField confirmPasswordField;


public void switchToLogIn() throws IOException {
    UIController.setRoot("/login");
}
}
