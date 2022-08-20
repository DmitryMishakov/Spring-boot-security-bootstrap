package com.mishakov.task.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column
    private String name;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Last name should be between 2 and 30 characters")
    @Column
    private String lastName;

//    @NotEmpty
//    @Column
//    private Long age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @Column
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Column()
    private String password;

    @Enumerated(value= EnumType.STRING)
    @Column()
    private Role role;


    public User() {
    }

    public User(Long id, String name, String lastName,/* Long age,*/ String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
//        this.age = age;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Long getAge() {
//        return age;
//    }
//
//    public void setAge(Long age) {
//        this.age = age;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
