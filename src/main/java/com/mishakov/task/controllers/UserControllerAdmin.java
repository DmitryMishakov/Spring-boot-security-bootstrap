package com.mishakov.task.controllers;

import com.mishakov.task.models.User;
import com.mishakov.task.services.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")
public class UserControllerAdmin {

    private final UserServices userServices;

    @Autowired
    public UserControllerAdmin(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('users:write')")
    public String adminUsers(Model model) {
        model.addAttribute("users", userServices.showByEmail(SecurityContextHolder
                .getContext().getAuthentication().getName()));
        model.addAttribute("listUser", userServices.listUsers());

        return "/admin";
    }

    @GetMapping("/admin/show")
    @PreAuthorize("hasAuthority('users:write')")
    @ResponseBody
    public User oneUser(Long id) {
        return userServices.oneUser(id);
    }


    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('users:write')")
    public String createUser(User user) {
        userServices.newUser(user);
        return "redirect:/admin";
    }


    @PatchMapping("/admin/update")
    @PreAuthorize("hasAuthority('users:write')")
    public String updateUser(User user) {
        userServices.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/delete")
    @PreAuthorize("hasAuthority('users:write')")
    public String deleteUser(User user) {
        userServices.deleteUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('users:read')")
    public String standardUser(Model model) {
        model.addAttribute("users",
                userServices.showByEmail(SecurityContextHolder
                        .getContext().getAuthentication().getName()));
        return "/user";
    }





}