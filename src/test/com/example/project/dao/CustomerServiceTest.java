package com.example.project.dao;

import com.example.project.entities.Users;
import com.example.project.models.CustomerModel;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {


    @Test
    void insertCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void fetchOnlineCustomersByGander() throws SQLException {
        var user = new Users("Ahmed", "Mire", "4303923", "Female",
                "afternoon", "jamko", "1122", null, "super_admin");


        System.out.println(CustomerService.fetchOnlineCustomersByGander(user));
    }

    @Test
    void fetchCustomer() throws SQLException {
        System.out.println(CustomerService.fetchCustomer("4303924"));
    }
}