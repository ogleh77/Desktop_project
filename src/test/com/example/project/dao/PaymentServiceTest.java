package com.example.project.dao;

import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import com.example.project.entities.services.Box;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void insertCustomerWithPayment() throws SQLException {

        var customer = new Customers("Luul", "Ahmed", "Jama",
                "4303924", "Female", "Morning", "Actober",
                null, 80, "jamko");

        Payments payments = new Payments(LocalDate.now().plusDays(30),
                12.0, "eDahab", 1, true, "4303924");

        Payments payments2 = new Payments(LocalDate.now().minusDays(30),
                32.0, "eDahab", 1, true, "4303924");

        Payments payments3 = new Payments(LocalDate.now(),
                1.0, "eDahab", 1, true, "4303924");

//
//        var customer = new Customers("Ibrahim", "Ali", "Deeq",
//                "4303926", "Male", "Morning", "Actober",
//                null, 80, "Ogleh");
//
//        Box box = new Box(1, "Box1", false);
//        Payments payments = new Payments(LocalDate.now().plusDays(30),
//                2.0, "Cash", 1, true, "4303926");
//        payments.setBox(box);
//
//        Payments payment2 = new Payments(LocalDate.now().minusDays(10),
//                2.0, "Cash", 1, true, "4303926");
//

        customer.getPayments().addAll(payments, payments2, payments3);

        PaymentService.insertCustomerWithPayment(customer);


    }

    @Test
    void fetchAllOnlinePayment() throws SQLException {

        System.out.println(PaymentService.fetchAllOnlinePayment("4303924"));
    }

    @Test
    void fetchAllCustomersPayments() throws SQLException {
        System.out.println(PaymentService.fetchAllCustomersPayments("4303924"));
    }

}