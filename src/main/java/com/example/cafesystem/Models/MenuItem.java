package com.example.cafesystem.Models;

public class MenuItem {
    private String menuItemName;
    private String description;
    private double price;
    private String category;
    private int calories;
    private boolean isAvailable;

    public MenuItem(String menuItemName, String description, double price, String category, int calories) {
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.calories = calories;
        isAvailable = true;
    }

    public MenuItem(String menuItemName, String description, String price, String category, String calories) {
        this.menuItemName = menuItemName;
        this.description = description;
        this.price = setPrice(price);
        this.category = category;
        this.calories = setCalories(calories);
        isAvailable = true;
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

    public int setCalories(String calories) {
        return this.calories = Integer.parseInt(calories);
    }

    public void InsertMenuItem() {

    }


    @Override
    public String toString() {
       // return String(menuItemName + " " + description + " " + price + " " + category + " " + calories + " " + isAvailable);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(menuItemName);
        stringBuilder.append(description);
        stringBuilder.append(price);
        stringBuilder.append(category);
        stringBuilder.append(calories);
        stringBuilder.append(isAvailable);

        return stringBuilder.toString();
    }
}
