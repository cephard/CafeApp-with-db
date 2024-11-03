package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.*;
import com.example.cafesystem.Models.User;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SignUpController extends UIController {

    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public DatePicker dataOfBirthField;
    public TextField phoneNumberField;
    public TextField passwordField;
    public TextField addressField;
    public PasswordField confirmPasswordField;

    private PopUpController popUpController = new PopUpController();
    private User user = new User();
    // private PopUp popUp = new PopUp();

    public void switchToLogIn() throws IOException {
        UIController.setRoot("/login");
    }

    //check if email is valid before saving
    public String checkEmail() {

        return emailField.getText();
    }

    //check the password if they match
    public String checkPassword() {
        String passwordMismatch = "Password mismatch";
        if (passwordField.getText().length() < 8) {
            String passwordShort = "Password must be at least 8 characters long";
            popUpController.showPopup("Error", passwordShort);
            throw new RuntimeException(passwordShort);
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            //do a pop-up to show the wrong password
            popUpController.showPopup("Error", passwordMismatch);
            throw new RuntimeException(passwordMismatch);
        } else {
            return Authenticator.harshPassword(passwordField.getText());
        }
    }

    public Long checkPhoneNumber() {
        String phoneNUmber = phoneNumberField.getText();
        if (phoneNUmber == null) {
            popUpController.showPopup("Title", "Phone number cannot be null");
        } else if (phoneNUmber.matches("\\d+")) {
            popUpController.showPopup("Erro", "Please enter a valid phone number");
        }
        return Long.parseLong(phoneNumberField.getText());
    }

    public void createUser() throws IOException {
        Stage stage = new Stage();
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setEmail(checkEmail());
        user.setDateOfBirth(dataOfBirthField);
        user.setPhoneNumber(checkPhoneNumber());
        user.setAddress(addressField.getText());
        user.setPassword(checkPassword());

        insertUser(user.userSet());
        popUpController.showPopup("Success", user.getFirstName() + "is successfully signed up!");
    }

    // Insert method to save user data
    public void insertUser(HashMap<String, Object> userSet) throws IOException {
        SqlQueries sqlQueries = new SqlQueries();
        sqlQueries.insertNewRecord("Users", userSet);

        String msg = user.getFirstName() + "";
    }
}
