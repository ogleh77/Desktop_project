package com.example.project.dao;

import com.example.project.entities.Users;
import com.example.project.helpers.CustomException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void insertUser() throws CustomException {

        var user = new Users("Ahmed", "Mire", "4303923", "Male",
                "afternoon", "jamko", "1122", null, null);

        UserService.insertUser(user);
    }


    @Test
    void fetchUsers() throws SQLException {
        System.out.println(UserService.users());
    }
}