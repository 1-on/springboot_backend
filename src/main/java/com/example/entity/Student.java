package com.example.entity;

import lombok.Data;

@Data
public class Student extends Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String birth;
    private String awatar;
    private String role;
}
