package com.example.project.controllers;

import com.example.project.entities.Customers;
import com.example.project.entities.services.Box;
import com.example.project.helpers.CommonCases;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PaymentController extends CommonCases implements Initializable {
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

    private double fitnessCost = 12.0;
    private double poxingCost = 2.0;
    private final double vipBoxCost = 3.0;

    private double currentCost = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            boxChooser.getItems().add(new Box(0, "remove box", true));
            boxChooser.getItems().add(new Box(0, "box5", true));
            boxChooser.getItems().add(new Box(2, "box6", true));
            boxChooser.getItems().add(new Box(4, "box4", true));
            paidBy.setItems(getPaidBy());
        });

        currentCost = fitnessCost;
        amountPaid.setText(String.valueOf(currentCost));

        boxChooser.valueProperty().addListener((observable, oldValue, newValue) -> {
            //Stop the user to name a box into remove or something insha Allah
            if ((oldValue == null || oldValue.getBoxName().matches("re.*")) && !newValue.getBoxName().matches("re.*")) {
                currentCost += vipBoxCost;
            } else if (oldValue != null && boxChooser.getValue().getBoxName().matches("re.*")) {
                currentCost -= vipBoxCost;
            }
            amountPaid.setText(String.valueOf(currentCost));
        });

        poxing.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (poxing.isSelected()) {
                currentCost += poxingCost;
            } else {
                currentCost -= poxingCost;
            }
            amountPaid.setText(String.valueOf((currentCost)));


        });

    }

    @FXML
    void saveHandler(ActionEvent event) {
        if (customer.getPayments().isEmpty()) {
            System.out.println("New customer with payment added");
        } else {
            System.out.println("New payment created by " + customer.getFirstName());
        }

    }


    private String validateDiscount() {

        if ((!discount.getText().isEmpty() || !discount.getText().isBlank())) {
            if (!discount.getText().matches("[0-9]*")) {
                discountValidtaion.setVisible(true);
                discountValidtaion.setText("discount must be digits only ");
                return "error";
            } else {

                double _discount = Double.parseDouble(discount.getText());

                double maxDiscount = 1.0;
                if (_discount > maxDiscount) {
                    discountValidtaion.setVisible(true);
                    discountValidtaion.setText("discount can't greater then max discount of $" + maxDiscount);
                    return "error";
                } else {
                    discountValidtaion.setVisible(false);
                    discountValidtaion.setText(null);
                    return null;
                }
            }
        }

        return null;
    }

    @Override
    public void setCustomer(Customers customer) {
        this.customer = customer;
        if (customer != null) {
            firstName.setText(customer.getFirstName());
            middleName.setText(customer.getFirstName());
            lastName.setText(customer.getFirstName());
            middleName.setText(customer.getMiddleName());
            lastName.setText(customer.getLastName());

            phone.setText(customer.getPhone());
            if (customer.getGander().equals("Male")) {
                male.setSelected(true);
            } else {
                female.setSelected(true);
            }
            try {
                if (customer.getImage() != null) {
                    imgView.setImage(new Image(new FileInputStream(customer.getImage())));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            expDate.setValue(LocalDate.now().plusDays(30));
            System.out.println(customer);
        }
    }
}
