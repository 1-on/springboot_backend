package com.yixian.controller;

import cn.hutool.core.util.ObjectUtil;
import com.yixian.common.Result;
import com.yixian.common.RoleEnum;
import com.yixian.entity.Account;
import com.yixian.exception.CustomException;
import com.yixian.service.AdminService;
import com.yixian.service.StudentService;
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

    @RequestMapping("/he")
    public String hello2(){
        return "spring";
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

    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())) {
            throw new CustomException("账号或密码必填");
        }
        studentService.register(account);
        return Result.success();

    }
}
