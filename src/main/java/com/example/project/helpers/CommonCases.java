package com.example.project.helpers;

import com.example.project.entities.Customers;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class CommonCases {
    public Customers customer;
    public File selectedFile;

    public Alert errorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle("Error occur");
        alert.showAndWait();
        return alert;
    }

    public Alert informationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle("congratulations");
        alert.showAndWait();
        return alert;
    }


    public File selectedFile() {
        FileChooser chooser = new FileChooser();
        selectedFile = chooser.showOpenDialog(null);
        return selectedFile;
    }

    public void setCustomer(Customers customer) throws FileNotFoundException {
        this.customer = customer;
    }
}
