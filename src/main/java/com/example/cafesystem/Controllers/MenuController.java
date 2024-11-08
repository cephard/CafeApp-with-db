package com.example.cafesystem.Controllers;

import com.example.cafesystem.Models.Menu;
import com.example.cafesystem.Models.MenuItem;
import com.example.cafesystem.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController extends UIController {
    @FXML
    private StackPane stackPane1;
    @FXML
    private StackPane stackPane2;
    @FXML
    private StackPane stackPane3;
    @FXML
    private StackPane stackPane4;
    @FXML
    private StackPane stackPane5;
    @FXML
    private StackPane stackPane6;
    @FXML
    private StackPane stackPane7;
    @FXML
    private StackPane stackPane8;
    @FXML
    private StackPane stackPane9;
    @FXML
    private StackPane stackPane10;
    @FXML
    private StackPane stackPane11;
    @FXML
    private StackPane stackPane12;

    @FXML
    private Label name1;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label name6;
    @FXML
    private Label name7;
    @FXML
    private Label name8;
    @FXML
    private Label name9;
    @FXML
    private Label name10;
    @FXML
    private Label name11;
    @FXML
    private Label name12;

    @FXML
    private Label price1;
    @FXML
    private Label price2;
    @FXML
    private Label price3;
    @FXML
    private Label price4;
    @FXML
    private Label price5;
    @FXML
    private Label price6;
    @FXML
    private Label price7;
    @FXML
    private Label price8;
    @FXML
    private Label price9;
    @FXML
    private Label price10;
    @FXML
    private Label price11;
    @FXML
    private Label price12;


    @FXML
    private Label calories1;
    @FXML
    private Label calories2;
    @FXML
    private Label calories3;
    @FXML
    private Label calories4;
    @FXML
    private Label calories5;
    @FXML
    private Label calories6;
    @FXML
    private Label calories7;
    @FXML
    private Label calories8;
    @FXML
    private Label calories9;
    @FXML
    private Label calories10;
    @FXML
    private Label calories11;
    @FXML
    private Label calories12;


    User user = LoginController.getUser();

    @FXML
    private Label customerName;
    private String currentCategory = "";

    private Menu menu = new Menu();

    private List<StackPane> stackPanes;
    private List<Label> nameLabels;
    private List<Label> priceLabels;
    private List<Label> caloriesLabels;

    public void initialize(URL location, ResourceBundle resources) {
        customerName.setText(user.getFirstName() + " " + user.getLastName());

        // Populate the stackPanes list
        stackPanes = Arrays.asList(stackPane1, stackPane2, stackPane3, stackPane4, stackPane5,
                stackPane6, stackPane7, stackPane8, stackPane9, stackPane10,
                stackPane11, stackPane12);

        // Populate the nameLabels list
        nameLabels = Arrays.asList(name1, name2, name3, name4, name5,
                name6, name7, name8, name9, name10,
                name11, name12);

        // Populate the priceLabels list
        priceLabels = Arrays.asList(price1, price2, price3, price4, price5,
                price6, price7, price8, price9, price10,
                price11, price12);

        // Populate the caloriesLabels list
        caloriesLabels = Arrays.asList(calories1, calories2, calories3, calories4,
                calories5, calories6, calories7, calories8,
                calories9, calories10, calories11, calories12);

        // Initialize each StackPane
        for (StackPane pane : stackPanes) {
            pane.setVisible(false); // Example action; modify as needed
        }
    }


    public void selectMenuCategory(javafx.scene.input.MouseEvent mouseEvent) {
        Label selectedLabel = (Label) mouseEvent.getSource();
        String category = selectedLabel.getText();


        int index = 0;
        for (MenuItem menuItem : menu.getMenu()) {

            if (menuItem.getCategory().equals(category) && !currentCategory.equals(category)) {
                System.out.println(menuItem);


                String imageLocation = "/Images/"+menuItem.getImageLocation();
                URL imageUrl = getClass().getResource(imageLocation);
                if (imageUrl != null) {
                    String imagePath = imageUrl.toExternalForm();
                    stackPanes.get(index).setStyle("-fx-background-image: url('" + imagePath + "');");
                } else {
                    System.out.println("Resource not found.");
                }

                stackPanes.get(index).setVisible(true);
                nameLabels.get(index).setText(menuItem.getMenuItemName());
                priceLabels.get(index).setText("£ " + String.valueOf(menuItem.getPrice()));
                caloriesLabels.get(index).setText(String.valueOf(menuItem.getCalories()) + " kcal");
                index++;
            }

        }
        currentCategory = category;
    }

    private void assignItemDetails(MenuItem menuItem) {
        for (int i = 0; i < 12; i++) {

        }
    }


}
