package com.example.project.models;

import com.example.project.entities.Users;
import com.example.project.helpers.IConnection;
import com.example.project.helpers.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class UsersModel implements Repo<Users> {
    private final static Connection connection = IConnection.getConnection();


    @Override
    public void insert(Users users) throws SQLException {
        String insertUserQuery = "INSERT INTO users(first_name, last_name, phone, gender, shift, username, password, image, role) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(insertUserQuery);

        ps.setString(1, users.getFirstName());
        ps.setString(2, users.getLastName());
        ps.setString(3, users.getPhone());
        ps.setString(4, users.getGender());
        ps.setString(5, users.getShift());
        ps.setString(6, users.getUsername());
        ps.setString(7, users.getPassword());
        ps.setString(8, users.getImage());
        ps.setString(9, users.getRole());
        ps.executeUpdate();
        ps.close();
        System.out.println("User inserted..");
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public ObservableList<Users> fetchAll() throws SQLException {
        String fetchQuery = "SELECT * FROM users";
        ObservableList<Users> users = FXCollections.observableArrayList();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(fetchQuery);

        Users user;
        while (rs.next()) {
            user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            users.add(user);
        }
        statement.close();
        rs.close();
        return users;
    }
}
