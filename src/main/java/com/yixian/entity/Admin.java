package com.yixian.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName admin
 */
@Data
public class Admin extends Account implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String role;

    private static final long serialVersionUID = 1L;
}