package com.example.project.entities;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers {
    private int customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String gander;
    private String shift;
    private String address;
    private String image;
    private double weight;
    private String whoAdded;

    private JFXButton information;
    private JFXButton payment;
    private JFXButton update;
    private ObservableList<Payments> payments;


    public Customers(int customerId, String firstName, String middleName, String lastName, String phone, String gander, String shift, String address, String image, double weight, String whoAdded) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.gander = gander;
        this.shift = shift;
        this.address = address;
        this.image = image;
        this.weight = weight;
        this.whoAdded = whoAdded;
//        this.information = new JFXButton("information");
//        this.update = new JFXButton("update");
//        this.payment = new JFXButton("payment");
//        information.setStyle("-fx-background-color: #1e6e66;-fx-text-fill: white;-fx-pref-width: 130;-fx-font-size: 14");
//        update.setStyle("-fx-background-color: dodgerblue;-fx-text-fill: white;-fx-pref-width: 80;-fx-font-size: 14");
//        payment.setStyle("-fx-background-color: #145ab6;-fx-text-fill: white;-fx-pref-width: 80;-fx-font-size: 14");
        this.payments = FXCollections.observableArrayList();

    }

    public Customers(String firstName, String middleName, String lastName, String phone, String gander, String shift, String address, String image, double weight, String whoAdded) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.gander = gander;
        this.shift = shift;
        this.address = address;
        this.image = image;
        this.weight = weight;
        this.whoAdded = whoAdded;
        this.payments = FXCollections.observableArrayList();
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getGander() {
        return gander;
    }

    public String getShift() {
        return shift;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public double getWeight() {
        return weight;
    }

    public String getWhoAdded() {
        return whoAdded;
    }

    public ObservableList<Payments> getPayments() {
        return payments;
    }

    public JFXButton getInformation() {
        return information;
    }

    public JFXButton getPayment() {
        return payment;
    }

    public JFXButton getUpdate() {
        return update;
    }

    public void setPayments(ObservableList<Payments> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "\n [customerId: " +
                customerId + " firstname: " +
                firstName + "  lastname: " +
                lastName + " gander " + gander + " phone: " + phone + "\n payments: " + payments + "]\n\n";
    }
}
