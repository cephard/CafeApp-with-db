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
    private Label nameLabel2;
    @FXML
    private Label nameLabel3;
    @FXML
    private Label nameLabel4;
    @FXML
    private Label nameLabel5;
    @FXML
    private Label nameLabel6;
    @FXML
    private Label nameLabel7;
    @FXML
    private Label nameLabel8;
    @FXML
    private Label nameLabel9;
    @FXML
    private Label nameLabel10;
    @FXML
    private Label nameLabel11;
    @FXML
    private Label nameLabel12;

    @FXML
    private Label price1;
    @FXML
    private Label priceLabel2;
    @FXML
    private Label priceLabel3;
    @FXML
    private Label priceLabel4;
    @FXML
    private Label priceLabel5;
    @FXML
    private Label priceLabel6;
    @FXML
    private Label priceLabel7;
    @FXML
    private Label priceLabel8;
    @FXML
    private Label priceLabel9;
    @FXML
    private Label priceLabel10;
    @FXML
    private Label priceLabel11;
    @FXML
    private Label priceLabel12;

    @FXML
    private Label calories1;
    @FXML
    private Label caloriesLabel2;
    @FXML
    private Label caloriesLabel3;
    @FXML
    private Label caloriesLabel4;
    @FXML
    private Label caloriesLabel5;
    @FXML
    private Label caloriesLabel6;
    @FXML
    private Label caloriesLabel7;
    @FXML
    private Label caloriesLabel8;
    @FXML
    private Label caloriesLabel9;
    @FXML
    private Label caloriesLabel10;
    @FXML
    private Label caloriesLabel11;
    @FXML
    private Label caloriesLabel12;

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
        nameLabels = Arrays.asList(name1, nameLabel2, nameLabel3, nameLabel4, nameLabel5,
                nameLabel6, nameLabel7, nameLabel8, nameLabel9, nameLabel10,
                nameLabel11, nameLabel12);

        // Populate the priceLabels list
        priceLabels = Arrays.asList(price1, priceLabel2, priceLabel3, priceLabel4, priceLabel5,
                priceLabel6, priceLabel7, priceLabel8, priceLabel9, priceLabel10,
                priceLabel11, priceLabel12);

        // Populate the caloriesLabels list
        caloriesLabels = Arrays.asList(calories1, caloriesLabel2, caloriesLabel3, caloriesLabel4,
                caloriesLabel5, caloriesLabel6, caloriesLabel7, caloriesLabel8,
                caloriesLabel9, caloriesLabel10, caloriesLabel11, caloriesLabel12);

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

            }
            index++;
        }
        currentCategory = category;
    }

    private void assignItemDetails(MenuItem menuItem) {
        for (int i = 0; i < 12; i++) {

        }
    }


}
