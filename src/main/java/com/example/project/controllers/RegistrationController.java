package com.example.project.controllers;

import com.example.project.dao.CustomerService;
import com.example.project.entities.Customers;
import com.example.project.helpers.CommonCases;
import com.example.project.helpers.CommonInterface;
import com.example.project.helpers.CustomException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    @FXML
    private Label headerInfo;

    @FXML
    private JFXButton registerBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

        });
    }

    @FXML
    void imageUploadHandler(ActionEvent event) {
        try {
            if (selectedFile() != null) {
                Image image = new Image(new FileInputStream(selectedFile.getAbsolutePath()));
                imgView.setImage(image);
                imgView.setX(50);
                imgView.setY(25);
                imgView.setFitHeight(166);
                imgView.setFitWidth(200);
            }
        } catch (FileNotFoundException e) {
            errorMessage("Fadlan sawirka lama helin isku day mar kale");
        }
    }

    @FXML
    void resetHandler(ActionEvent event) {

    }

    @FXML
    void stepTwoHandler(ActionEvent event) {
//        if (customer == null) {
//            System.out.println("customer is " + customer);
//            try {
//                CustomerService.insertCustomer(customer());
//                informationAlert("Hablyo waxaad Diwaan gelisay customer cusub");
//            } catch (CustomException e) {
//                errorMessage(e.getMessage());
//            }
//
//        } else {
//            try {
//                CustomerService.updateCustomer(customer());
//                informationAlert("Hablyo waxaad update garaysay customer cusub");
//            } catch (CustomException e) {
//                errorMessage(e.getMessage());
//            }
//            System.out.println(customer);
//        }
        System.out.println(selectedFile);
    }


    @Override
    public void setCustomer(Customers customer) throws FileNotFoundException {
        this.customer = customer;

        firstName.setText(customer.getFirstName());
        middleName.setText(customer.getMiddleName());
        lastName.setText(customer.getLastName());

        phone.setText(customer.getPhone());
        weight.setText(String.valueOf(customer.getWeight()));
        shift.setValue(customer.getShift());
        address.setText(customer.getAddress() != null ? customer.getAddress() : "No address");

        if (customer.getGander().equals("Male")) {
            male.setSelected(true);
        } else {
            female.setSelected(true);
        }
        weight.setText(String.valueOf(customer.getWeight()));
        shift.setValue(customer.getShift());
        address.setText(customer.getAddress() != null ? customer.getAddress() : "No address");

        if (customer.getImage() != null) {
            imgView.setImage(new Image(new FileInputStream(customer.getImage())));
        }

        headerInfo.setText("UPDATING EXISTED CUSTOMER INFO");

        registerBtn.setText("Update Customer");
    }


    private Customers customer() throws CustomException {
        String gander = male.isSelected() ? "Male" : "Female";
        String _address = address.getText() != null ? address.getText().trim() : null;
        double _weight = ((!weight.getText().isEmpty() || !weight.getText().isBlank())) ? Double.parseDouble(weight.getText().trim()) : 65.0;
      //  String image = imageUploaded() != null ? imageUploaded().getUrl() : null;
        int customerId = super.customer == null ? null : customer.getCustomerId();

//        Customers customer = new Customers(customerId, firstName.getText(), middleName.getText(), lastName.getText(),
//                phone.getText(), gander, shift.getValue(), _address, image, _weight,
//                "Ogleh");


        return customer;
    }
}
