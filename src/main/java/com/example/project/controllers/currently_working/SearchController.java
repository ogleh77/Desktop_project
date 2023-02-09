package com.example.project.controllers.currently_working;

import com.example.project.entities.Customers;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    private TableColumn<Customers, String> fName;

    @FXML
    private TableColumn<Customers, JFXButton> information;

    @FXML
    private TableColumn<Customers, String> middleName;

    @FXML
    private TableColumn<Customers, JFXButton> payment;

    @FXML
    private TableColumn<Customers, String> phone;
    @FXML
    private TableColumn<Customers, JFXButton> update;

    @FXML
    private TableView<Customers> tView;

    @FXML
    private TextField searchField;

    private FilteredList<Customers> filteredList;
    private SortedList<Customers> sortedList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            initTable();
            searchByTable();
        });
    }

    private void initTable() {
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        information.setCellValueFactory(new PropertyValueFactory<>("information"));
        payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        update.setCellValueFactory(new PropertyValueFactory<>("update"));

        tView.setItems(customers());
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


    private void searchByTable() {
        filteredList = new FilteredList<>(customers(), b -> true);
        sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(tView.comparatorProperty());
        tView.setItems(sortedList);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if (customer.getFirstName().contains(newValue.toLowerCase()) || customer.getFirstName().contains(newValue.toUpperCase())) {
                    return true;
                } else if (customer.getPhone().contains(newValue)) {
                    return true;
                } else if (customer.getLastName().contains(newValue.toLowerCase()) || customer.getLastName().contains(newValue.toUpperCase())) {
                    return true;
                } else {
                    return false;
                }
            });
        });
    }
}
