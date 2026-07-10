package com.tap.dao;

import java.util.List;

import com.tap.module.User;

public interface Userdao {

    // Add a new user
    void addUser(User user);

    // Get user by ID
    User getUser(int userId);

    // Update existing user
    void updateUser(User user);

    // Delete user by ID
    void deleteUser(int userId);

    // Get all users
    List<User> getAllUsers();

    // Get user by email
    User getUserByEmail(String email);

    // Validate login
    User validateUser(String email, String password);
}