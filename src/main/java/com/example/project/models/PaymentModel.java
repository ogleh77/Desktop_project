package com.example.project.models;

import com.example.project.entities.Payments;
import com.example.project.helpers.IConnection;
import com.example.project.helpers.Repo;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public class PaymentModel implements Repo<Payments> {

    public static final Connection connection = IConnection.getConnection();


    @Override
    public void insert(Payments payments) throws SQLException {

    }

    @Override
    public void update(Payments payments) throws SQLException {

    }

    @Override
    public ObservableList<Payments> fetchAll() throws SQLException {
        return null;
    }
}
