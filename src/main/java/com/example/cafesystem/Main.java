package com.example.cafesystem;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();

    String createMenuItemTable = "CREATE TABLE MenuItem (" +
            "MenuItemID INTEGER PRIMARY KEY," +
            "Name VARCHAR(100) NOT NULL," +
            "Description TEXT," +
            "Price DECIMAL(10, 2) NOT NULL," +
            "Category VARCHAR(50)," +
            "IsAvailable BOOLEAN DEFAULT 1," +
            "CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")";


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Cafe App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() {
        dataBaseSetUp.stopConnection();
    }
}