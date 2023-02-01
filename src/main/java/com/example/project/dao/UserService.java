package com.example.project.dao;

import com.example.project.entities.Users;
import com.example.project.helpers.CustomException;
import com.example.project.models.UsersModel;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class UserService {
    private final static UsersModel usersModel = new UsersModel();
    public static void insertUser(Users user) throws CustomException {
        try {
            usersModel.insert(user);
        } catch (SQLException e) {
            if (e.getMessage().contains("(UNIQUE constraint failed: users.username)")) {
                throw new CustomException("username-kan hore ayaa loo isticmalay fadlan dooro mid kale");
            } else {
                throw new CustomException("Khalad baa ka dhacay " + e.getMessage());
            }
        }
    }
    public static ObservableList<Users> users() throws SQLException {
        ObservableList<Users> users = null;
        try {
            users = usersModel.fetchAll();
            //add default user
            users.add(new Users(0, "Luul", "Muuse", "4476619", "Male",
                    "Morning", "lulka **", "4000", null, "super admin"));
        } catch (SQLException e) {
            throw e;
        }
        return users;
    }
}