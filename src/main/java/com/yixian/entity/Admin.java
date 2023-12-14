package com.yixian.entity;

import lombok.Data;

@Data
public class Admin extends Account{
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String role;
}
