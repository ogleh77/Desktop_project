package com.example.project.controllers;

import com.example.project.dao.UserService;
import com.example.project.entities.Users;
import com.example.project.helpers.CommonCases;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginControllers extends CommonCases implements Initializable {
    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<Users> userCombo;
    private Stage currentStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            try {
                currentStage = (Stage) userCombo.getScene().getWindow();
                userCombo.setItems(UserService.users());
            } catch (SQLException e) {
                //   throw new RuntimeException(e);
                errorMessage("error:- " + e.getMessage());
            }
        });
    }


    @FXML
    void exitHandler(MouseEvent event) {
        currentStage.close();
    }

    @FXML
    void loginHandler(ActionEvent event) {

        Users activeUser = userCombo.getValue();

        if (password.getText().equals(activeUser.getPassword())) {
            System.out.println("Welcome");
        } else {
            errorMessage("fadlan password-kaaad gelisay wa khalad isku day mar kale ");
        }
    }
}
