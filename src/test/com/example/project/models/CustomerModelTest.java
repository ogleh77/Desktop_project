package com.example.project.models;

import com.example.project.dao.CustomerService;
import com.example.project.entities.Customers;
import com.example.project.entities.Users;
import com.example.project.helpers.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerModelTest {

    @Test
    void insert() throws CustomException {

        var customer = new Customers("Mohamed", "Saeed", "Ogleh",
                "4303923", "Male", "Afternoon", "Tuurta",
                null, 70, "ogleh");

        CustomerService.insertCustomer(customer);
    }

    @Test
    void update() throws CustomException {
        var customer = new Customers(1, "Luul", "Ahmed", "Jama",
                "4303923", "Female", "Morning", "Actober",
                null, 80, "jamko");

        CustomerService.updateCustomer(customer);
    }

    @Test
    void fetchAll() {
    }

    @Test
    void fetchByRoleAndGander() {
        var user = new Users("Ahmed", "Mire", "4303923", "Female",
                "afternoon", "jamko", "1122", null, "super_admin");

        //System.out.println(CustomerModel.fetchByRoleAndGander(user));
    }
}