package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Authenticator;
import com.example.cafesystem.Models.Customer;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        System.out.println(passwordField.getText() +"  " + confirmPasswordField.getText());

        if(!passwordField.getText().equals(confirmPasswordField.getText())){
            //do a pop-up to show wrong password
            return null;

        }else{
            return Authenticator.harshPassword(passwordField.getText());
        }
    }


    public int checkPhoneNumber(){
        return Integer.parseInt(phoneNumberField.getText());
    }

    public void createCustomer(){
        customer = new Customer();
        customer.setFirstName(firstNameField.getText());
        customer.setLastName(lastNameField.getText());
        customer.setEmail(checkEmail());
        customer.setDateOfBirth(dataOfBirthField);
        customer.setPhoneNumber(checkPhoneNumber());
        customer.setAddress(addressField.getText());
        customer.setPassword(checkPassword());

        System.out.println(customer.toString());
}
}
