package com.yixian.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@Data
public class Student extends Account implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 学号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private String birth;

    /**
     * 头像
     */
    private String awatar;

    /**
     * 角色
     */
    private String role;

    private static final long serialVersionUID = 1L;
}