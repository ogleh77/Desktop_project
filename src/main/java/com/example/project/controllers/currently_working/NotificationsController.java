package com.example.project.controllers.currently_working;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NotificationsController implements Initializable {

    @FXML
    private GridPane customerGridView;
    int column = 0;
    int row = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void load() throws IOException {

        for (int i = 0; i < 30; i++) {
            if (column == 2) {
                column = 0;
                row++;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/project/views/info/customer-card2.fxml"));
            AnchorPane anchorPane = loader.load();
            customerGridView.add(anchorPane, column++, row);

//            GridPane.setMargin(customerGridView, new Insets(200));

        }
    }


}
