package com.example.cafesystem.Models;

import java.util.HashMap;

public class MenuItem {
    private String menuItemName;
    private String description;
    private double price;
    private String category;
    private int calories;
    private boolean isAvailable;
    private String imageLocation;
    private int quantity;


    public MenuItem(String menuItemName, String description, double price, String category, int calories) {
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.calories = calories;
        isAvailable = true;
        quantity = 1;
    }

    public MenuItem(String menuItemName, String description, int price, String category, boolean isAvailable, int calories, String imageLocation) {
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.calories = calories;
        this.isAvailable = isAvailable;
        this.imageLocation = imageLocation;
        quantity = 1;
    }

    public MenuItem() {
        isAvailable = true;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double setPrice(String price) {
        return this.price = Double.parseDouble(price);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public int getQuantity() {
        return quantity;
    }

    //assigns new quantity
    public void setQuantity(int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity cannot be less than 1");
        this.quantity = quantity;
    }

    //increases quantity by one
    public void increamentQuantity() {
        this.quantity++;
    }

    //
    public HashMap<String, Object> menuItemSet() {
        HashMap<String, Object> menuItem = new HashMap<String, Object>();
        menuItem.put("name", menuItemName);
        menuItem.put("price", price);
        menuItem.put("calories", calories);
        menuItem.put("category", category);
        menuItem.put("description", description);
        menuItem.put("is_available", isAvailable);
        menuItem.put("image_location", imageLocation);
        return menuItem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(menuItemName);
        stringBuilder.append(description);
        stringBuilder.append(price);
        stringBuilder.append(category);
        stringBuilder.append(calories);
        stringBuilder.append(isAvailable);
        stringBuilder.append(imageLocation);

        return stringBuilder.toString();
    }
}
