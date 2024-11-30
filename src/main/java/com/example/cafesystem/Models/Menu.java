package com.example.cafesystem.Models;

import com.example.cafesystem.CRUD.DataBaseSetUp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
    private MenuItem menuItem;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public Menu() {
        DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();
        dataBaseSetUp.createConnection();
        String loadMenuItems = "SELECT * FROM MenuItems";
        try {
            PreparedStatement preparedStatement = dataBaseSetUp.getConnection().prepareStatement(loadMenuItems);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                //directly creating an item from the database
                menuItem = new MenuItem(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));

                menuItems.add(menuItem);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dataBaseSetUp.stopConnection();
    }


    public ArrayList<MenuItem> getMenu() {
        return menuItems;
    }

    public int getMenuSize() {
        return menuItems.size();
    }
}
