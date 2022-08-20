package com.mishakov.task.services;



import com.mishakov.task.models.User;

import java.util.List;

public interface UserServices {
    List<User> listUsers();

    User newUser(User user);

    User oneUser(Long userId);

    User showByEmail(String email);

    User updateUser(User user);

    void deleteUser(User user);
}
