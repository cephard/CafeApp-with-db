package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Customer;
import com.example.cafesystem.Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends UIController {
    User user = LoginController.getUser();

    @FXML
    private Label customerName;

    public void initialize(URL location, ResourceBundle resources) {
        customerName.setText(user.getFirstName() + " " + user.getLastName());
    }
}
