package com.example.cafesystem.Controllers;

import com.example.cafesystem.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class UIController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openLogIn() throws IOException {
        setRoot("/login");
    }

    public void openMenu() throws IOException {
        setRoot("/menu");
    }

    public void openCart() throws IOException {
        setRoot("/Cart");
    }

    public void openStaff() throws IOException {
        setRoot("/Staff");
    }

    public void openStaffProfile() throws IOException {
        setRoot("/StaffProfile");
    }
}

