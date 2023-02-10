package com.example.project.dao;

import com.example.project.entities.Customers;
import com.example.project.entities.Users;
import com.example.project.helpers.CustomException;
import com.example.project.models.CustomerModel;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerService {
    private static final CustomerModel customerModel = new CustomerModel();

    public static void insertCustomer(Customers customer) throws CustomException {
        try {
            customerModel.insert(customer);
        } catch (SQLException e) {
            if (e.getMessage().contains("(UNIQUE constraint failed: customers.phone)")) {
                throw new CustomException("Lanbarkan hore ayaa loo diwaan geshay fadlan dooro lanbarkale");
            } else {
                throw new CustomException("Khalad ayaaa ka dhacay " + e.getMessage());
            }
        }
    }

    public static void updateCustomer(Customers customer) throws CustomException {
        try {
            customerModel.update(customer);
        } catch (SQLException e) {
            if (e.getMessage().contains("(UNIQUE constraint failed: customers.phone)")) {
                throw new CustomException("Lanbarkan hore ayaa loo diwaan geshay fadlan dooro lanbarkale");
            } else {
                throw new CustomException("Khalad ayaaa ka dhacay " + e.getMessage());
            }
        }
    }


    public static ObservableList<Customers> fetchOnlineCustomersByGander(Users activeUser) throws SQLException {
        return customerModel.fetchOnlineCustomersByGander(activeUser);
    }

    public static Customers fetchCustomer(String phone) throws SQLException {
        return customerModel.fetchCustomer(phone);
    }
}
