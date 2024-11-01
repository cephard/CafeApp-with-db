package com.example.cafesystem;

import com.example.cafesystem.CRUD.DataBaseSetUp;
import com.example.cafesystem.Controllers.UIController;
import com.example.cafesystem.Models.SqlQueries;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    DataBaseSetUp dataBaseSetUp = new DataBaseSetUp();

    @Override
    public void start(Stage stage) throws IOException {
        UIController.loadNewStage(stage,"/login");
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() {
        dataBaseSetUp.stopConnection();
    }
}