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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

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
            male.setToggleGroup(genderGroup);
            female.setToggleGroup(genderGroup);
            shift.setItems(super.getShift());
            mandatoryFields.addAll(firstName, middleName, lastName, phone, shift);
        });
    }

    @FXML
    void imageUploadHandler(ActionEvent event) {
        try {
            if (selectedFile() != null) {
                imageUploaded = true;
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
    void stepTwoHandler(ActionEvent event) throws CustomException {
        checkImageForgot("Sawirkii maad ilowdey mise ogaan bad u dhaftey");
        System.out.println("Image uploaded " + imageUploaded);

        if (imageUploaded) {
            System.out.println("U can pass");
        }
//        if (isValid(mandatoryFields, genderGroup) && phoneCheck() == null) {
//            System.out.println("Valid");
//        } else {
//            System.out.println("Invalid");
//        }
//        try {
//            if (customer == null) {
//                CustomerService.insertCustomer(customer());
//                informationAlert("Hablyo waxaad Diwaan gelisay customer cusub");
//            } else {
//                CustomerService.updateCustomer(customer());
//                informationAlert("Hablyo waxaad update garaysay customer cusub");
//            }
//        } catch (CustomException e) {
//            errorMessage(e.getMessage());
//        }
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
        String image = selectedFile != null ? selectedFile.getAbsolutePath() : null;
        int customerId = super.customer == null ? 0 : customer.getCustomerId();

        Customers customer = new Customers(customerId, firstName.getText(), middleName.getText(), lastName.getText(), phone.getText(), gander, shift.getValue(), _address, image, _weight, "Ogleh");


        return customer;
    }


    private String phoneCheck() {
        if (!phone.getText().matches("[0-9]*")) {
            messageValidation.setVisible(true);
            messageValidation.setText("phone must be digits only");
            return "error";
        } else if (!phone.getText().matches("^\\d{7}")) {
            messageValidation.setVisible(true);
            messageValidation.setText("phone can't be greater than 7 digits or less");
            return "error";
        }
        messageValidation.setVisible(false);
        return null;

    }


}
