package com.example.project.controllers;

import com.example.project.entities.Customers;
import com.example.project.entities.services.Box;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    @FXML
    private TextField amountPaid;

    @FXML
    private ComboBox<Box> boxChooser;

    @FXML
    private TextField discount;

    @FXML
    private Label discountValidtaion;

    @FXML
    private DatePicker expDate;

    @FXML
    private JFXRadioButton female;

    @FXML
    private TextField firstName;

    @FXML
    private TextField firstName1;

    @FXML
    private ImageView imgView;

    @FXML
    private TextField lastName;

    @FXML
    private JFXRadioButton male;

    @FXML
    private TextField middleName;

    @FXML
    private ComboBox<String> paidBy;

    @FXML
    private TextField phone;

    @FXML
    private JFXCheckBox poxing;
    @FXML
    private TextField searchField;
    private AutoCompletionBinding<Customers> autoCompletionBinding;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            autoCompletionBinding = TextFields.bindAutoCompletion(searchField, customers());
        });

    }

    @FXML
    void saveHandler(ActionEvent event) {

    }


    private ObservableList<Customers> customers() {
        ObservableList<Customers> customer = FXCollections.observableArrayList();

        customer.add(new Customers(1, "Luul", "Ahmed", "Jama",
                "4303924", "Female", "Morning", "Actober",
                null, 80, "jamko"));

        customer.add(new Customers(1, "Mohamed", "Ali", "Jama",
                "4303925", "Female", "Morning", "Actober",
                null, 80, "jamko"));

        customer.add(new Customers(1, "Khadar", "Muuse", "Jama",
                "34322224", "Female", "Morning", "Actober",
                null, 80, "jamko"));

        customer.add(new Customers(1, "Cilmi", "Husein", "Jama",
                "333333", "Female", "Morning", "Actober",
                null, 80, "jamko"));

        customer.add(new Customers(1, "Yare", "Gure", "Jama",
                "4303911", "Female", "Morning", "Actober",
                null, 80, "jamko"));

        return customer;
    }
}
