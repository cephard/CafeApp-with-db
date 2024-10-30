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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    Customer customer;
    PopUpController popUpController;
    SqlQueries sqlQueries;

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

        sqlQueries = new SqlQueries();
        //sqlQueries.insertNewRecord("Customers",);
     //   insertCustomer(customer);
      //  popUpController.showPopup("popup", "/popup", "Account successfully created");
    }








    // Insert method to save customer data
    public void insertCustomerr(Customer customer) {
         DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();

        dataBaseSetUp.createConnection();
        String sql = "INSERT INTO Customers (first_name, last_name, email, date_of_birth, phone_number, address, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = dataBaseSetUp.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getDateOfBirth().toString());
            pstmt.setLong(5, customer.getPhoneNumber());
            pstmt.setString(6, customer.getAddress());
            pstmt.setString(7, customer.getPassword());

            pstmt.executeUpdate();

            System.out.println("Customer added successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to insert customer: " + e.getMessage());
        } finally {
           dataBaseSetUp.stopConnection();
        }
    }
}
