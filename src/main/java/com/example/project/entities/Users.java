package com.example.project.entities;

public class Users {
    private int userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String shift;
    private String username;
    private String password;
    private String image;
    private String role;

    public Users(int userId, String firstName, String lastName, String phone, String gender, String shift, String username, String password, String image, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.shift = shift;
        this.username = username;
        this.password = password;
        this.image = image;
        this.role = role;
    }

    public Users(String firstName, String lastName, String phone, String gender, String shift, String username, String password, String image, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.shift = shift;
        this.username = username;
        this.password = password;
        this.image = image;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getShift() {
        return shift;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "[" + username + " role:- " + role + "]\n";
    }
}
