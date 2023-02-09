package com.example.project.dao;

import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void insertCustomerWithPayment() throws SQLException {

//        var customer = new Customers("Luul", "Ahmed", "Jama",
//                "4303924", "Female", "Morning", "Actober",
//                null, 80, "jamko");

//        Payments payments = new Payments(LocalDate.now().plusDays(30),
//                12.0, "eDahab", 1, true, "4303924");
//
//        Payments payments2 = new Payments(LocalDate.now().minusDays(30),
//                32.0, "eDahab", 1, true, "4303924");
//
//        Payments payments3 = new Payments(LocalDate.now(),
//                1.0, "eDahab", 1, true, "4303924");


        var customer = new Customers("Jama", "Muuse", "Jama",
                "4303925", "Female", "Morning", "Actober",
                null, 80, "Ogleh");

        Payments payments = new Payments(LocalDate.now().plusDays(20),
                42.0, "Zaad", 1, true, "4303925");

        customer.getPayments().addAll(payments);

        PaymentService.insertCustomerWithPayment(customer);


    }

    @Test
    void fetchAllOnlinePayment() throws SQLException {

        System.out.println(PaymentService.fetchAllOnlinePayment("4303925"));
    }

    @Test
    void fetchAllCustomersPayments() throws SQLException {
        System.out.println(PaymentService.fetchAllCustomersPayments("4303922"));
    }
}