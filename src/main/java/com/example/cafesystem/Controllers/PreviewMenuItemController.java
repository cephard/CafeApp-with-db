package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
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

    private Image image;
    private ImageHandler imageHandler;

    public void initialize(URL location, ResourceBundle resources) {
        MenuItem selectedItem = MenuController.getSelectedItem();
        itemName.setText(selectedItem.getMenuItemName());
        itemPrice.setText(String.valueOf(selectedItem.getPrice()));
        itemCalories.setText(String.valueOf(selectedItem.getCalories()));
        itemDescription.setText(selectedItem.getDescription());
        imageHandler =  new ImageHandler();
        URL imageUrl = imageHandler.getImageUrl("/Images/" + selectedItem.getImageLocation());
        Image image = new Image(String.valueOf(imageUrl));
        itemImage.setImage(image);
    }

    public void returnToMenu() throws IOException {
        setRoot("/menu");
    }
}
