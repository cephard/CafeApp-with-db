package com.example.cafesystem.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ObservableList<MenuItem> itemsInCart;
    private static final String CART_FILE_PATH = "src/main/resources/cart.json";

    public Cart() {
        itemsInCart = loadCartFromJson();
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu Item cannot be null");
        }

        boolean exists = itemsInCart.stream().anyMatch(cartItem -> cartItem.getMenuItemName().equalsIgnoreCase(item.getMenuItemName()));

        if (exists) {
            System.out.println("Item is already in the cart.");
        } else {
            itemsInCart.add(item);
            saveCartToJson(); // Update the JSON file
            System.out.println("Item added to the cart successfully.");
        }
    }

    public void removeItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu Item cannot be null");
        }

        boolean removed = itemsInCart.removeIf(cartItem ->
                cartItem.getMenuItemName().equalsIgnoreCase(item.getMenuItemName()));

        if (removed) {
            saveCartToJson(); // Update the JSON file
            System.out.println("Item removed from the cart successfully.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public List<MenuItem> getItemsInCart() {
        return itemsInCart;
    }

    // Save the cart to JSON
    private void saveCartToJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(CART_FILE_PATH), itemsInCart);
        } catch (IOException e) {
            System.err.println("Error saving cart to JSON: " + e.getMessage());
        }
    }

    // Load the cart from JSON
    private ObservableList<MenuItem> loadCartFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(CART_FILE_PATH);

        if (!file.exists()) {
            try {
                // Create the file and initialize it with an empty JSON array
                file.createNewFile();
                mapper.writeValue(file, new ArrayList<MenuItem>());
                System.out.println("Cart file created: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error creating new cart file: " + e.getMessage());
            }
        }

        try {
            // Check if the file is empty before trying to read it
            if (file.length() == 0) {
                return FXCollections.observableArrayList(); // Return an empty ObservableList if the file is empty
            }

            // Read the existing file and return as an ObservableList
            List<MenuItem> list = mapper.readValue(
                    file,
                    mapper.getTypeFactory().constructCollectionType(List.class, MenuItem.class)
            );

            return FXCollections.observableArrayList(list);
        } catch (IOException e) {
            System.err.println("Error loading cart from JSON: " + e.getMessage());
        }

        return FXCollections.observableArrayList();
    }
}

