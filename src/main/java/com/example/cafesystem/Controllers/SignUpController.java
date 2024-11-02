package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.Authenticator;
import com.example.cafesystem.Models.User;
import com.example.cafesystem.Models.SqlQueries;
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

    User user = new User();

    public void switchToLogIn() throws IOException {
    UIController.setRoot("/login");
    }

    //check if email is valid before saving
    public String checkEmail(){

        return emailField.getText();
    }

    //check the password if they match
    public String checkPassword(){
        if(!passwordField.getText().equals(confirmPasswordField.getText())){
            //do a pop-up to show the wrong password
            return null;

        }else{
            return Authenticator.harshPassword(passwordField.getText());
        }
    }

    public Long checkPhoneNumber(){
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

        System.out.println(user.toString());
        insertUser(user.userSet());
      //  popUpController.showPopup("popup", "/popup", "Account successfully created");
    }

    // Insert method to save user data
    public void insertUser(HashMap<String, Object> userSet) throws IOException {
        SqlQueries sqlQueries = new SqlQueries();
        sqlQueries.insertNewRecord("Users", userSet);

        String msg = user.getFirstName() + " successfully signed up!";
        PopUpController popUpController = new PopUpController();
        popUpController.showPopup();
    }
}
