package com.example.cafesystem.Controllers;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AddMenuItemController {
    private final ImageHandler imageHandler = new ImageHandler();
    private File selectedImage;
    @FXML public TextField itemCalories;
    @FXML public TextArea itemDescription;
    @FXML public ImageView itemImage;
    @FXML public CheckBox isAvailable;
    @FXML private TextField itemName;
    @FXML private TextField itemPrice;

    @FXML private Button addButton;

    private String selectedCategory;

    MenuItem menuItem = new MenuItem();


    public void getSelectedCategory(javafx.scene.input.MouseEvent mouseEvent) {
        Label selectedLabel = (Label) mouseEvent.getSource();
        String category = selectedLabel.getText();
        selectedCategory = category;
        System.out.println("Selected Category: " + category);
    }

    public void selectImage(){
        selectedImage = imageHandler.loadImage();
        imageHandler.regenerateImage(selectedImage, itemImage);
    }

    public void addMenuItem() {
        menuItem.setMenuItemName(itemName.getText());
        menuItem.setDescription(itemDescription.getText());
        menuItem.setPrice(itemPrice.getText());
        menuItem.setCategory(selectedCategory);
        menuItem.setCalories(itemCalories.getText());
        menuItem.setImageLocation(imageHandler.saveImg(selectedImage, itemName.getText()));
        menuItem.setAvailable(isAvailable.isSelected());

        menuItem.menuItemSet();

        System.out.println(menuItem.toString());
        System.out.println("All is good");
    }
}
