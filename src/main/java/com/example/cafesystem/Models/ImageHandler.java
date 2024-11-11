package com.example.cafesystem.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import javax.swing.plaf.synth.Region;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ImageHandler {

    //Choose a file from explorer
    public File loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/resources"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg"));
        return fileChooser.showOpenDialog(null);
    }

    //regenerate image from URI
    public void regenerateImage(File selectedImg, ImageView imageView) {
        if (selectedImg != null) {
            String imageURI = selectedImg.toURI().toString();
            imageView.setImage(new Image(imageURI));
        } else {
            System.out.println("File selection cancelled.");
        }
    }

    //save image using URI
    public String saveImg(File selectedImg, String newImageName) {
        String imageName = newImageName + ".png";
        String newLocation = "src/main/resources/Images/" + imageName;
        try {
            Files.copy(selectedImg.toPath(), Paths.get(newLocation));
            System.out.println("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageName;
    }

    public void setStackPaneBackground(StackPane container, String imageLocation) {
        URL imageUrl = getClass().getResource(imageLocation);
        if (imageUrl != null) {
            String imagePath = imageUrl.toExternalForm();
            container.setStyle("-fx-background-image: url('" + imagePath + "');");
        } else {
            System.out.println("Resource not found.");
        }
    }
}
