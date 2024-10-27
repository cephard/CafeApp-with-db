package com.example.cafesystem;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Models.SqlQueries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();
    SqlQueries sqlQueries = new SqlQueries();

    @Override
    public void start(Stage stage) throws IOException {
        dataBaseSetUp.createConnection();

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