package com.example.project.controllers.currently_working;

import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import com.example.project.helpers.CommonCases;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerInfoController extends CommonCases implements Initializable {
    @FXML
    private TableColumn<Payments, Double> amountPaid;

    @FXML
    private TableColumn<Payments, Double> discount;

    @FXML
    private TableColumn<Payments, LocalDate> expDate;

    @FXML
    private TableColumn<Payments, String> month;

    @FXML
    private TableColumn<Payments, String> paidBy;

    @FXML
    private TableColumn<Payments, String> paymentDate;

    @FXML
    private TableColumn<Payments, JFXButton> pendingBtn;

    @FXML
    private TableColumn<Payments, String> poxing;

    @FXML
    private TableColumn<Payments, String> running;

    @FXML
    private TableView<Payments> tableView;

    @FXML
    private TableColumn<Payments, String> vipBox;

    @FXML
    private TableColumn<Payments, String> year;


    @FXML
    private ImageView imgView;

    @FXML
    private Label fullName;

    @FXML
    private Label address;

    @FXML
    private Label phone;

    @FXML
    private Label shift;
    @FXML
    private Label weight;
    @FXML
    private Label gander;
    @FXML
    private Label whoAdded;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            initTable();
        });
    }


    private void initTable() {
        amountPaid.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));

        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        expDate.setCellValueFactory(new PropertyValueFactory<>("expDate"));

        month.setCellValueFactory(new PropertyValueFactory<>("month"));

        paidBy.setCellValueFactory(new PropertyValueFactory<>("paidBy"));

        paymentDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        pendingBtn.setCellValueFactory(new PropertyValueFactory<>("pendingBtn"));

        poxing.setCellValueFactory(payment -> new SimpleStringProperty(payment.getValue().isPoxing() ? "Yes" : "No"));

        running.setCellValueFactory(payment -> new SimpleStringProperty(payment.getValue().isOnline() ? "Yes" : "No"));

        vipBox.setCellValueFactory(payment -> new SimpleStringProperty(payment.getValue().getBox() != null ? "Yes" : "No"));

        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        tableView.setItems(customer.getPayments());

    }


    @Override
    public void setCustomer(Customers customer) throws FileNotFoundException {
        super.customer = customer;
        System.out.println("customer " + customer);
        fullName.setText(customer.getFirstName() + " " + customer.getMiddleName() + " " + customer.getLastName());
        phone.setText(customer.getPhone());
        gander.setText(customer.getGander());
        address.setText(customer.getAddress() == null ? " no address " : customer.getAddress());
        shift.setText(customer.getShift());
        weight.setText(customer.getWeight() + "");
        whoAdded.setText(customer.getWhoAdded());

    }
}
