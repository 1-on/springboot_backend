package com.example.controller;

import com.example.common.Result;
import com.example.common.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.service.AdminService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        Account dbAccount;
        if (RoleEnum.ADMIN.name().equals(account.getRole())) { // 管理员登陆
            dbAccount = adminService.login(account);
        } else if (RoleEnum.STUDENT.name().equals(account.getRole())) {
            dbAccount = studentService.login(account);
        } else {
            return Result.error("角色错误");
        }
        return Result.success(dbAccount);
    }
}
