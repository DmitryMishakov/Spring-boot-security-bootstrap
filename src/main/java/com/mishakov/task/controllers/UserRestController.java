package com.mishakov.task.controllers;

import com.mishakov.task.models.User;
import com.mishakov.task.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private final UserServices userServices;

    @Autowired

    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/j_users")
    public List<User> allUsers() {
        return userServices.listUsers();
    }

    @GetMapping("/j_user/{userId}")
    public User oneUser(@PathVariable Long userId) {
        return userServices.oneUser(userId);
    }

    @PostMapping("/j_new")
    public User newUser(@RequestBody User user) {
        return userServices.newUser(user);
    }

    @PatchMapping("/j_update")
    public User updateUser(@RequestBody User user) {
        return userServices.updateUser(user);
    }

    @DeleteMapping("/j_delete")
    public String deleteUser(@RequestBody User user) {
        userServices.deleteUser(user);
        return "user deleted";
    }
}
