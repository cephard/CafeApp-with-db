package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Authenticator;
import com.example.cafesystem.Models.Customer;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController extends UIController {

    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public DatePicker dataOfBirthField;
    public TextField phoneNumberField;
    public TextField passwordField;
    public TextField addressField;
    public PasswordField confirmPasswordField;

    Customer customer;

    public void switchToLogIn() throws IOException {
    UIController.setRoot("/login");
    }

    //check if email is valid before saving
    public String checkEmail(){

        return emailField.getText();
    }

    //check password if they match
    public String checkPassword(){
        if(!passwordField.getText().equals(confirmPasswordField.getText())){
            //do a pop-up to show wrong password
            return null;

        }else{
            return Authenticator.harshPassword(passwordField.getText());
        }
    }


    public Long checkPhoneNumber(){
        return Long.parseLong(phoneNumberField.getText());
    }

    public void createCustomer() throws IOException {
        Stage stage = new Stage();
        customer = new Customer();
        customer.setFirstName(firstNameField.getText());
        customer.setLastName(lastNameField.getText());
        customer.setEmail(checkEmail());
        customer.setDateOfBirth(dataOfBirthField);
        customer.setPhoneNumber(checkPhoneNumber());
        customer.setAddress(addressField.getText());
        customer.setPassword(checkPassword());

        System.out.println(customer.toString());
        UIController.showPopup("popup", "/popup");
      //  UIController.setPopUpText(customer.toString());

}
}
