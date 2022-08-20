package com.mishakov.task.services;


import com.mishakov.task.dao.UserDao;
import com.mishakov.task.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServicesImp implements UserServices {

    private final UserDao userDao;

    @Autowired
    public UserServicesImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User newUser(User user) {
        return userDao.newUser(user);
    }

    @Override
    public User oneUser(Long userId) {
        return userDao.oneUser(userId);
    }

    @Override
    public User showByEmail(String email) {
        return userDao.showByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
