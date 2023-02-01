package com.example.project.helpers;

import com.example.project.entities.Users;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface Repo<T> {
    void insert(T t) throws SQLException;

    void update(T t) throws SQLException;

    default ObservableList<T> fetchCustomersByGander(Users activeUser) throws SQLException {
        return null;
    }

    ObservableList<T> fetchAll() throws SQLException;

    default void delete(T t) {
    }

    default T fetch() {
        return null;
    }
}
