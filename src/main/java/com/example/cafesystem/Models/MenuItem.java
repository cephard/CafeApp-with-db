package com.example.cafesystem.Models;

public class MenuItem {
    private String menuItemName;
    private String description;
    private double price;
    private String category;
    private String calories;
    private boolean isAvailable;

    public MenuItem(String menuItemName,String description,double price,String category,String calories){
         this.menuItemName = menuItemName;
        this.description = description;
        this.price =price;
        this.category = category;
        this.calories = calories;
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

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void InsertMenuItem(){

    }
}
