package com.example.project.dao;

import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import com.example.project.models.PaymentModel;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public class PaymentService {

    private static final PaymentModel paymentModel = new PaymentModel();

    public static void insertCustomerWithPayment(Customers customer) throws SQLException {

        String customerPhone = customer.getPhone();
        String customerGander = customer.getGander();
        LocalDate deadLine = LocalDate.now().plusDays(30);

        if (!customer.getPayments().isEmpty()) {
            for (Payments payment : customer.getPayments()) {
                if (payment.getExpDate().isEqual(deadLine) || payment.getExpDate().isBefore(deadLine)) {
                    System.out.println("This payment is new " + payment.getExpDate() + " " + payment.isOnline());
                    //Insert Payment into the database
                    paymentModel.insertPayment(customerPhone, customerGander, payment);
                    break;
                }
            }

        }
    }


    public static ObservableList<Payments> fetchAllOnlinePayment(String customerPhone) throws SQLException {
        return paymentModel.fetchAllOnlinePayment(customerPhone);
    }


    public static ObservableList<Payments> fetchAllCustomersPayments(String customerPhone) throws SQLException {
        return paymentModel.fetchAllCustomersPayments(customerPhone);
    }


}
