package com.example.project.controllers;

import com.example.project.helpers.CommonCases;
import com.example.project.helpers.CommonInterface;
import com.example.project.helpers.CustomException;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends CommonCases implements Initializable {
    @FXML
    private TextField address;

    @FXML
    private Label customerId;

    @FXML
    private JFXRadioButton female;

    @FXML
    private TextField firstName;

    @FXML
    private ImageView imgView;

    @FXML
    private TextField lastName;

    @FXML
    private JFXRadioButton male;

    @FXML
    private Label messageValidation;

    @FXML
    private TextField middleName;

    @FXML
    private TextField phone;

    @FXML
    private ComboBox<String> shift;

    @FXML
    private TextField weight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void imageUploadHandler(ActionEvent event) {
        try {
            Image image = imageUploaded();
            if (image != null) {
                imgView.setImage(image);
                imgView.setX(50);
                imgView.setY(25);
                imgView.setFitHeight(166);
                imgView.setFitWidth(200);
            }
        } catch (CustomException e) {
            errorMessage(e.getMessage());
        }
    }

    @FXML
    void resetHandler(ActionEvent event) {

    }

    @FXML
    void stepTwoHandler(ActionEvent event) {

    }

}
