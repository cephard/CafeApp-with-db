// Class that handles the UI elements when entering a new Item into the database

package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import com.example.cafesystem.Models.SqlQueries;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.io.File;

public class AddMenuItemController {
    private final ImageHandler imageHandler = new ImageHandler();
    private File selectedImage;
    @FXML private TextField itemCalories;
    @FXML private TextArea itemDescription;
    @FXML private ImageView itemImage;
    @FXML private CheckBox isAvailable;
    @FXML private TextField itemName;
    @FXML private TextField itemPrice;

    @FXML private Button addButton;

    private String selectedCategory;

    MenuItem menuItem = new MenuItem();
    private PopUpController popUpController = new PopUpController();

    //checking all the npt fields if to ensure null values are not entered
    private void checkNullValues(Object value, String valueName) {
        if (value == null) {
            popUpController.showPopup(valueName + " Error", valueName + " cannot be null");
            throw new IllegalArgumentException("Price cannot be null");
        }
    }

    //Checks mouse event and assigns menuItem category name based on the Label id
    public void getSelectedCategory(javafx.scene.input.MouseEvent mouseEvent) {
        Label selectedLabel = (Label) mouseEvent.getSource();
        String category = selectedLabel.getText();
        selectedCategory = category;
        System.out.println("Selected Category: " + category);
    }

    //Ensuring the item has been assigned a category
    public String checkCategory(){
        checkNullValues(selectedCategory, "Category");
        return selectedCategory;
    }

    //
    public void selectImage() {
        selectedImage = imageHandler.loadImage();
        imageHandler.generateImage(selectedImage, itemImage);
    }

    private String checkName() {
        String name = itemName.getText();
        checkNullValues(name,"Name");
        return name;
    }

    private String checkDescription() {
        String description = itemDescription.getText();
        checkNullValues(description, "Description");
        return description;
    }

    private double checkPrice() {
        String priceText = itemPrice.getText();
        checkNullValues(priceText, "Price");

        if (!priceText.matches("-?\\d+(\\.\\d+)?")) {
            popUpController.showPopup("Price Error", "Failed: Enter correct price format");
            throw new IllegalArgumentException("price must be a double");
        }
        return menuItem.setPrice(priceText);
    }

    private int checkCalories(){
        String calories = itemCalories.getText();
        checkNullValues(calories, "Calories");
        return Integer.parseInt(calories);
    }

    //
        public void addMenuItem () {
            checkNullValues(selectedImage, "Image");
            menuItem.setMenuItemName(checkName());
            menuItem.setDescription(checkDescription());
            menuItem.setPrice(checkPrice());
            menuItem.setCategory(checkCategory());
            menuItem.setCalories(checkCalories());
            menuItem.setImageLocation(imageHandler.saveImg(selectedImage, itemName.getText()));
            menuItem.setAvailable(isAvailable.isSelected());
            menuItem.menuItemSet();

            SqlQueries sqlQueries = new SqlQueries();
            sqlQueries.insertNewRecord("MenuItems", menuItem.menuItemSet());

            popUpController.showPopup("Success", menuItem.getMenuItemName() + " successfully added!");

        }
    }
