package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Cart;
import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreviewMenuItemController extends UIController {

    @FXML
    private Spinner<Integer> quantitySpinner;  // Change to Spinner
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
    private int quantity;

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

        // Initialize quantity spinner with a range and step
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, menuItem.getQuantity(), 1);
        quantitySpinner.setValueFactory(valueFactory);

        checkItemInCart(selectedItem);
    }

    private void checkItemInCart(MenuItem item) {
        for (int i = 0; i < cart.getItemsInCart().size(); i++) {
            MenuItem itemInCart = cart.getItemsInCart().get(i);
            if (item.getMenuItemName().equals(itemInCart.getMenuItemName())) {
                quantitySpinner.getValueFactory().setValue(itemInCart.getQuantity());  // Set spinner value
            }
        }
    }

    public void addItemToCart() {
        quantity = quantitySpinner.getValue();  // Get value from spinner
        menuItem.setQuantity(quantity);  // Set the selected quantity
        cart.addItem(menuItem);
    }

    public void removeItemFromCart() throws IOException {
        cart.removeItem(menuItem);
        setRoot("/menu");
    }

    @Override
    public void openCart() throws IOException {
        addItemToCart();
        setRoot("/Cart");
    }
}
