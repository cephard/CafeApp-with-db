package com.example.cafesystem.Controllers;

import com.example.cafesystem.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UIController {

    private static Scene scene;

    public static void loadNewStage(Stage stage, String FXMLPath) throws IOException {
        scene = new Scene(loadFXML(FXMLPath), 700, 480);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
    }


    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

