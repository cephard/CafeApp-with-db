package com.example.cafesystem.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class PopUpController extends UIController {

    @FXML Text popUpText;
    @FXML
    Button exitButton;

    public void showPopup(String title, String msg) {
        // Load FXML for the popup
        Parent popupContent = null;
        try {
            popupContent = loadFXML("/popup");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage popupStage = new Stage();

        // Block interaction with other windows
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);


        //access the text directly from XML otherwise it will be null
        Text popupText = (Text) popupContent.lookup("#popUpText");
        if (popupText != null) {
            popupText.setText(msg);
        }

        // Match the prefWidth/prefHeight in FXML
        popupStage.setScene(new Scene(popupContent, 426, 240));
        popupStage.setResizable(false);
        popupStage.setFullScreen(false);

        // Display the popup and wait until it's closed
        popupStage.showAndWait();
    }

    // Get the current stage and close it
    @FXML public void exitPopUp(){
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
    }
}
