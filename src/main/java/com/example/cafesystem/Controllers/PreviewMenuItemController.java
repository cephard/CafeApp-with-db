package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Cart;
import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import com.example.cafesystem.Models.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javax.swing.plaf.MenuItemUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreviewMenuItemController extends UIController {

    @FXML
    private TextField quantityText;
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

    private ImageHandler imageHandler;

    private Cart cart;
    private MenuItem menuItem;

    public void initialize(URL location, ResourceBundle resources) {
        cart = new Cart();

        MenuItem selectedItem = MenuController.getSelectedItem();
        itemName.setText(selectedItem.getMenuItemName());
        itemPrice.setText(String.valueOf(selectedItem.getPrice()));
        itemCalories.setText(String.valueOf(selectedItem.getCalories()));
        itemDescription.setText(selectedItem.getDescription());
        imageHandler = new ImageHandler();
        URL imageUrl = imageHandler.getImageUrl("/Images/" + selectedItem.getImageLocation());
        Image image = new Image(String.valueOf(imageUrl));
        itemImage.setImage(image);

        menuItem = selectedItem;

        checkItemInCart(selectedItem);
    }

    private void checkItemInCart(MenuItem item) {
        for (int i = 0; i < cart.getItemsInCart().size(); i++) {
            MenuItem itemInCart = cart.getItemsInCart().get(i);
            if (item.getMenuItemName().equals(itemInCart.getMenuItemName())) {
                quantityText.setText(String.valueOf(itemInCart.getQuantity()));
            }
        }
    }

    public void addItemToCart() {
        cart.addItem(menuItem);
    }

    public void removeItemToCart() {
        cart.removeItem(menuItem);
    }

}
