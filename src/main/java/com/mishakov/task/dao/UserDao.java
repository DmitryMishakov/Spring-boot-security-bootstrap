package com.mishakov.task.dao;



import com.mishakov.task.models.User;

import java.util.List;

public interface UserDao {
        List<User> listUsers();

        User newUser(User user);

        User showByEmail(String email);

        User oneUser(Long userId);

        User updateUser(User user);

        void deleteUser(User user);
}
