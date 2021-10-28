package ru.stedbbc.spring_boot.service;

import ru.stedbbc.spring_boot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByUsername(String name);

    User getUserByEmail(String email);

    boolean existsUserById(long id);
}
