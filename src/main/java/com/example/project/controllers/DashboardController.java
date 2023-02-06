package com.example.project.controllers;

import com.example.project.HelloApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private HBox menuHbox;

    @FXML
    private TextField searchField;

    @FXML
    private HBox topProfile;

    private boolean openSearch = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void menuClicked(MouseEvent event) {

    }

    @FXML
    void notificationMouseHandler(MouseEvent event) {

    }


    @FXML
    void searchHandler(MouseEvent event) {
        Stage searchStage = null;
        try {
            openSearch = !openSearch;
            if (openSearch) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/views/curently-process/search-pane.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                searchStage = new Stage();
                searchStage.setScene(scene);
                searchStage.initStyle(StageStyle.UNDECORATED);
                searchStage.show();
            } else {
                searchStage.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void topPaneHandler(MouseEvent event) {
        //searchStage.close();
    }
}
