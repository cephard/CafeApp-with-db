package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreviewMenuItemController extends UIController {
    @FXML
    private Label itemDescription;
    @FXML
    private ImageView itemImage;
    @FXML
    private Label itemCalories;
    @FXML
    private Label itemPrice;
    @FXML
    private Label itemName;


    public void initialize(URL location, ResourceBundle resources) {
        MenuItem selectedItem = MenuController.getSelectedItem();
        itemName.setText(selectedItem.getMenuItemName());
        itemPrice.setText(String.valueOf(selectedItem.getPrice()));
        itemCalories.setText(String.valueOf(selectedItem.getCalories()));
        itemDescription.setText(selectedItem.getDescription());

        ImageHandler imageHandler = new ImageHandler();
        //Image image = imageHandler.generateImage(menuItemImage,);
        //menuItemImage.setImage();

    }

    public void returnToMenu() throws IOException {
        setRoot("/menu");
    }
}
