package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddMenuItemController {
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescription;
    @FXML
    private TextField itemPrice;
    @FXML
    private CheckBox isAvailable;

    @FXML
    private Label beverage;
    @FXML
    private Label breakfast;
    @FXML
    private Label salad;
    @FXML
    private Label soup;
    @FXML
    private Label dessert;

    @FXML
    private Button backButton;
    @FXML
    private Button addButton;

    private String[] categories = {"Beverage", "Breakfast", "Salad", "Soup", "Dessert"};
    
}