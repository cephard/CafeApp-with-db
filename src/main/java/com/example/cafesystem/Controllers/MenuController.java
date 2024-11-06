package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Menu;
import com.example.cafesystem.Models.MenuItem;
import com.example.cafesystem.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends UIController {
    User user = LoginController.getUser();

    @FXML
    private Label customerName;
    private String currentCategory = "currentCategory";

    private Menu menu = new Menu();

    public void initialize(URL location, ResourceBundle resources) {
        customerName.setText(user.getFirstName() + " " + user.getLastName());
    }

    public void selectMenuCategory(javafx.scene.input.MouseEvent mouseEvent) {
        Label selectedLabel = (Label) mouseEvent.getSource();
        String category = selectedLabel.getText();

        for (MenuItem menuItem : menu.getMenu()) {
            if (menuItem.getCategory().equals(category) && !currentCategory.equals(category)) {
                System.out.println(menuItem);
            }
        }
        currentCategory = category;
    }


}
