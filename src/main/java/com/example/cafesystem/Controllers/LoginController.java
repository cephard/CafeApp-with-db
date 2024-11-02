package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.Authenticator;
import com.example.cafesystem.Models.Customer;
import com.example.cafesystem.Models.SqlQueries;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends UIController {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button backButton;
    @FXML
    private Button resultButton;

    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    @FXML
    public void switchToSignUp() throws IOException {
        UIController.setRoot("/signup");
    }

    @FXML
    public void retrieveUser() {
        readRecord(userNameField.getText(), Authenticator.harshPassword(passwordField.getText()));
    }

    public void readRecord(String userName, String userPassword) {
        DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();
        dataBaseSetUp.createConnection();

        String readUser = "Select * from Customers WHERE first_name = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = dataBaseSetUp.getConnection().prepareStatement(readUser);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                UIController.setRoot("/menu");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
