package com.example.cafesystem.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the shopping cart for the user, allowing the addition and removal of items,
 * as well as saving and loading the cart data to/from a JSON file.
 */
public class Cart {

    // List of items currently in the cart
    private List<MenuItem> itemsInCart;

    // File path for the cart JSON data
    private static final String CART_FILE_PATH = "src/main/resources/cart.json";

    /**
     * Constructor for the Cart class. Initializes the cart by loading existing items
     * from the JSON file or creating a new cart if the file doesn't exist.
     */
    public Cart() {
        itemsInCart = loadCartFromJson();
    }

    /**
     * Adds a MenuItem to the cart. If the item already exists in the cart, its quantity is updated.
     *
     * @param item The MenuItem to be added to the cart.
     * @throws IllegalArgumentException If the provided item is null.
     */
    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu Item cannot be null");
        }

        // Flag to check if the item already exists in the cart
        boolean itemExists = false;

        // Iterate through the items in the cart to check if the item already exists
        for (MenuItem cartItem : itemsInCart) {
            if (cartItem.getMenuItemName().equals(item.getMenuItemName())) {
                cartItem.setQuantity(item.getQuantity());
                System.out.println("Item successfully updated.");
                itemExists = true;  // Mark that the item was found and updated
                break;  // Exit the loop once the item is updated
            }
        }

        // If the item doesn't exist in the cart, add it
        if (!itemExists) {
            itemsInCart.add(item);
            System.out.println("Item added to the cart successfully.");
        }
        saveCartToJson();
    }

    /**
     * Removes a MenuItem from the cart based on the item's name.
     *
     * @param item The MenuItem to be removed from the cart.
     * @throws IllegalArgumentException If the provided item is null.
     */
    public void removeItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu Item cannot be null");
        }

        // Attempt to remove the item from the cart if it exists
        boolean removed = itemsInCart.removeIf(cartItem ->
                cartItem.getMenuItemName().equalsIgnoreCase(item.getMenuItemName()));

        // Check if the item was successfully removed
        if (removed) {
            // Save the updated cart to the JSON file
            saveCartToJson();
            System.out.println("Item removed from the cart successfully.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    /**
     * Retrieves the list of items currently in the cart.
     *
     * @return A list of MenuItems in the cart.
     */
    public List<MenuItem> getItemsInCart() {
        return itemsInCart;
    }

    /**
     * Saves the current cart data (items) to a JSON file.
     * The cart is saved as a list of MenuItems.
     */
    private void saveCartToJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Write the current list of items to the specified JSON file
            mapper.writeValue(new File(CART_FILE_PATH), itemsInCart);
        } catch (IOException e) {
            System.err.println("Error saving cart to JSON: " + e.getMessage());
        }
    }

    private void createCart(File file, ObjectMapper mapper) {
        // If the file doesn't exist, create a new file and initialize it with an empty cart
        if (!file.exists()) {
            try {
                file.createNewFile();  // Create the file
                mapper.writeValue(file, new ArrayList<MenuItem>());  // Write an empty list to the file
                System.out.println("Cart file created: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error creating new cart file: " + e.getMessage());
            }
        }
    }

    /**
     * Loads the cart data from a JSON file. If the file doesn't exist or is empty, an empty cart is returned.
     *
     * @return A list of MenuItems representing the cart's contents.
     */
    private List<MenuItem> loadCartFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(CART_FILE_PATH);
        createCart(file, mapper);

        try {
            // Check if the file is empty, and return an empty list if true
            if (file.length() == 0) {
                return new ArrayList<>();
            }

            // Read the existing file and return its contents as a list of MenuItems
            List<MenuItem> list = mapper.readValue(
                    file,
                    mapper.getTypeFactory().constructCollectionType(List.class, MenuItem.class)
            );

            return list;
        } catch (IOException e) {
            System.err.println("Error loading cart from JSON: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
