package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Cart;
import com.example.cafesystem.Models.ImageHandler;
import com.example.cafesystem.Models.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController extends UIController {

    @FXML
    private ListView<MenuItem> cartListView;

    private Cart cart;
    private ImageHandler imageHandler;
    @FXML
    private Label totalPriceLabel;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        // Initialize the cart and load items
        cart = new Cart();
        imageHandler = new ImageHandler();

        // Get the ObservableList of items in the cart
        ObservableList<MenuItem> itemsInCart = FXCollections.observableArrayList(cart.getItemsInCart());

        // Bind the ObservableList to the ListView
        cartListView.setItems(itemsInCart);

        // Set a custom cell factory for the ListView
        cartListView.setCellFactory(listView -> new ListCell<>() {
            private final HBox content;
            private final ImageView imageView;
            private final Label text;

            {
                imageView = new ImageView();
                imageView.setFitHeight(100); // Set image size
                imageView.setFitWidth(100); // Set image size
                text = new Label();
                content = new HBox(10, imageView, text); // Layout with spacing
            }

            @Override
            protected void updateItem(MenuItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // Set the image for the item
                    if (item.getImageLocation() != null) {
                        URL imageUrl = imageHandler.getImageUrl("/Images/" + item.getImageLocation());
                        Image image = new Image(String.valueOf(imageUrl));
                        imageView.setImage(image);
                    } else {
                        imageView.setImage(null); // No image
                    }

                    // Set the text for the item
                    text.setText(item.getMenuItemName() + ",  £ " + item.getPrice() + ", "
                            + item.getCalories() + " Kcal,  Quantity " + item.getQuantity());
                    setGraphic(content);
                }
            }
        });
        updateTotalPrice();
    }

    // Method to calculate and update the total price
    private void updateTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : cart.getItemsInCart()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        // Set the total price in the label
        totalPriceLabel.setText("£ " + String.format("%.2f", totalPrice));
    }
}
