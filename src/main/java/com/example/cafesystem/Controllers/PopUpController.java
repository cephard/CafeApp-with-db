package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.PopUp;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopUpController extends UIController {

    @FXML
    private Text popUpText;

    @FXML
    public void showPopup() throws IOException {

        Parent popupContent = loadFXML("/popup"); // Load FXML for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);  // Block interaction with other windows
        popupStage.setTitle(PopUp.getTitle());
        popUpText.setText(PopUp.getMessage());
        popupStage.setScene(new Scene(popupContent, 426, 240));  // Match the prefWidth/prefHeight in FXML

        popupStage.setResizable(false);
        popupStage.setFullScreen(false);


        popupStage.showAndWait();  // Display the popup and wait until it's closed
    }



    public void updatePopUpMsg() {
        popUpText.setText("new text");
    }
}
