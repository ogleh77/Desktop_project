package com.example.project.helpers;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class CommonCases {

    private File selectedFile;

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


    public Image imageUploaded() throws CustomException {
        FileChooser chooser = new FileChooser();
        Image image = null;
        selectedFile = chooser.showOpenDialog(null);
        try {
            if (selectedFile != null) {
                image = new Image(new FileInputStream(selectedFile.getAbsolutePath()));
            }
        } catch (FileNotFoundException exception) {
            throw new CustomException("Fadlan sawirka lama helin isku day mar kale");
        }
        return image;
    }

}
