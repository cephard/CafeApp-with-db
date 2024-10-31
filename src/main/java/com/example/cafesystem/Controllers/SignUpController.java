package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.Authenticator;
import com.example.cafesystem.Models.Customer;
import com.example.cafesystem.Models.SqlQueries;
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

    DataBaseSetUp dataBaseSetUp;
    Customer customer = new Customer();
    PopUpController popUpController;


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
            //do a pop-up to show the wrong password
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
        customer.setFirstName(firstNameField.getText());
        customer.setLastName(lastNameField.getText());
        customer.setEmail(checkEmail());
        customer.setDateOfBirth(dataOfBirthField);
        customer.setPhoneNumber(checkPhoneNumber());
        customer.setAddress(addressField.getText());
        customer.setPassword(checkPassword());

        System.out.println(customer.toString());
        insertCustomer(customer.customerSet());
      //  popUpController.showPopup("popup", "/popup", "Account successfully created");
    }

    // Insert method to save customer data
    public void insertCustomer(HashMap<String, Object> customerSet) throws IOException {
        SqlQueries sqlQueries = new SqlQueries();
        sqlQueries.insertNewRecord("Customers", customerSet);

        String msg = customer.getFirstName() + " successfully signed up!";
        PopUpController popUpController = new PopUpController();
        popUpController.showPopup("Success", msg);
    }
}
