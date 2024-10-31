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
    public TextField itemCalories;
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
        ImageHandler imageHandler = new ImageHandler();
        File selectedImage = imageHandler.loadImage();
        imageHandler.regenerateImage(selectedImage, itemImage);
        imageHandler.saveImg(selectedImage, itemName.getText());

    }

    public void selectImagee() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/resources/Images"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg"));

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);

        // Check if a file was selected
        if (selectedFile != null) {
            // Get the path of the selected file
            String imagePath = selectedFile.getAbsolutePath();

            // Optional: Display the image path in a TextField or Label
            System.out.println("Selected Image Path: " + imagePath);

            //regenerate image from URI
            String imageURI = selectedFile.toURI().toString();
            itemImage.setImage(new Image(imageURI));

            //save image using uri
            try {
                Files.copy(selectedFile.toPath(), Paths.get("src/main/resources/Images/" + "ceph2.png"));
                System.out.println("success");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("File selection cancelled.");
        }
    }

    public void addMenuItem() {
        menuItem.setMenuItemName(itemName.getText());
        menuItem.setDescription(itemDescription.getText());
        menuItem.setPrice(itemPrice.getText());
        menuItem.setCategory(selectedCategory);
        menuItem.setCalories(itemCalories.getText());

        System.out.println(menuItem.toString());
    }


}