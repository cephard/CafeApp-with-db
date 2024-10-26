package com.example.cafesystem.Models;

public class SqlQueries {

    public static String CREATE_MENU_ITEM_TABLE = "CREATE TABLE MenuItem (" +
            "MenuItemID INTEGER PRIMARY KEY," +
            "Name VARCHAR(100) NOT NULL," +
            "Description TEXT," +
            "Price DECIMAL(10, 2) NOT NULL," +
            "Category VARCHAR(50)," +
            "IsAvailable BOOLEAN DEFAULT 1," +
            "CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public static String CREATE_MENU_TABLE ="";
    public static String CREATE_ORDER_TABLE ="";
    public static String CREATE_USER_TABLE ="";
    public static String CREATE_CUSTOMER_TABLE ="";
    public static String CREATE_STAFF_TABLE ="";
    public static String CREATE_SERVICES_TABLE ="";
}
