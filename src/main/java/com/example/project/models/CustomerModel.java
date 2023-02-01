package com.example.project.models;

import com.example.project.entities.Customers;
import com.example.project.entities.Users;
import com.example.project.helpers.CustomException;
import com.example.project.helpers.IConnection;
import com.example.project.helpers.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CustomerModel implements Repo<Customers> {
    public static int limit = 0;
    public static Connection connection = IConnection.getConnection();

    @Override
    public void insert(Customers customer) throws SQLException {
        String insertQuery = "INSERT INTO customers(first_name, middle_name, last_name, phone, gander, shift, address, image, weight, who_added)\n" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertOrUpdateStatement(customer, insertQuery, true);
    }

    @Override
    public void update(Customers customer) throws SQLException {
        String updateQuery = "UPDATE customers SET first_name=?,middle_name=?,last_name=?,phone=?,gander=?,shift=?, " +
                "address=?,image=?,weight=? WHERE customer_id=" + customer.getCustomerId();
        insertOrUpdateStatement(customer, updateQuery, false);
    }

    @Override
    public ObservableList<Customers> fetchCustomersByGander(Users activeUser) throws SQLException {

        ObservableList<Customers> customers = FXCollections.observableArrayList();

        String fetchingQueryWithGander = fetchByRoleAndGander(activeUser);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(fetchingQueryWithGander);



        return Repo.super.fetchCustomersByGander(activeUser);
    }

    @Override
    public ObservableList<Customers> fetchAll() {
        return null;
    }


    //--------Helper methods------------
    //-----------Insert or updating statement------------
    private void insertOrUpdateStatement(Customers customer, String query, boolean insert) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getMiddleName());
        ps.setString(3, customer.getLastName());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getGander());
        ps.setString(6, customer.getShift());
        ps.setString(7, customer.getAddress());
        ps.setString(8, customer.getImage());
        ps.setDouble(9, customer.getWeight());
        if (insert) {
            ps.setString(10, customer.getWhoAdded());
            System.out.println("Customer added");
        } else {
            System.out.println("Customer Updated..");
        }
        ps.executeUpdate();
        ps.close();
    }

    private static String fetchByRoleAndGander(Users activeUser) {

        String fetchQuery = "SELECT * FROM customers WHERE gander='" + activeUser.getGender() + "'";

        if (activeUser.getRole().equals("super_admin")) {
            System.out.println("Active customer is " + activeUser.getRole());
            fetchQuery = "SELECT * FROM customers";
        }
        return fetchQuery;
    }
}
