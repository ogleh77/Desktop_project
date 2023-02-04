package com.example.project.helpers;

import animatefx.animation.Shake;
import com.example.project.entities.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public abstract class CommonCases {
    public Customers customer;
    public File selectedFile;
    private final ObservableList<String> shift;
    private final ObservableList<String> paidBy;
    public ToggleGroup genderGroup;
    public ObservableList<Control> mandatoryFields;
    private final Shake shake;

    public boolean imageUploaded = true;

    public CommonCases() {
        this.mandatoryFields = FXCollections.observableArrayList();
        shift = FXCollections.observableArrayList();
        paidBy = FXCollections.observableArrayList();
        this.genderGroup = new ToggleGroup();
        this.shift.addAll("Morning", "Noon", "Afternoon", "Night");
        this.paidBy.addAll("eDahab", "Zaad service", "other");
        this.shake = new Shake();
    }

    protected boolean isValid(ObservableList<Control> mandatoryFields, ToggleGroup group) {
        boolean isValid = true;
        try {
            for (Control control : mandatoryFields) {
                if (control instanceof TextInputControl) {
                    if ((((TextInputControl) control).getText().isBlank() || ((TextInputControl) control).getText().isEmpty())) {
                        shake.setNode(control);
                        control.setStyle("-fx-border-color: #cb3d3d;-fx-border-width: 2");
                        shake.play();
                        isValid = false;
                    } else {
                        control.setStyle(null);
                    }
                } else if (control instanceof ComboBoxBase<?> && (((ComboBoxBase<?>) control).getValue() == null)) {
                    shake.setNode(control);
                    shake.play();
                    control.setStyle("-fx-border-color: #cb3d3d;-fx-border-width: 2");
                    isValid = false;
                } else {
                    control.setStyle(null);
                }
            }
            if (group.getSelectedToggle() == null) {
                shake.setNode((Node) group.getToggles().get(0));
                shake.play();
                shake.setNode((Node) group.getToggles().get(1));
                ((Node) group.getToggles().get(0)).setStyle("-fx-border-color: #cb3d3d;-fx-border-width: 2");
                ((Node) group.getToggles().get(1)).setStyle("-fx-border-color: #cb3d3d;-fx-border-width: 2");
                shake.play();
                isValid = false;
            } else {
                ((Node) group.getToggles().get(0)).setStyle(null);
                ((Node) group.getToggles().get(1)).setStyle(null);
            }
        } catch (NullPointerException e) {
            //  System.out.println(e.getMessage());
        }
        return isValid;
    }

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

    public ObservableList<String> getShift() {
        return shift;
    }

    public ObservableList<String> getPaidBy() {
        return paidBy;
    }


    public void checkImageForgot(String message) {
        if (selectedFile == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
            alert.setTitle("Image forget");
            Optional<ButtonType> config = alert.showAndWait();
            if (config.get().getButtonData().isDefaultButton()) {
                imageUploaded = true;
                System.out.println("Ok pressed..");
                alert.close();
            } else {
                imageUploaded = false;
                System.out.println("Canceled");
            }
        }
    }
}
