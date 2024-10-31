package com.example.cafesystem.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageHandler {

    //Choose a file from explorer
    public File loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/resources"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg","*.png", "*.jpeg"));
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

    public void saveImg(File selectedImg,String imageName) {
        //save image using URI
        try {
            Files.copy(selectedImg.toPath(), Paths.get("src/main/resources/Images/" + imageName +".png"));
            System.out.println("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
