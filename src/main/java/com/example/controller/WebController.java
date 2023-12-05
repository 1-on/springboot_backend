package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    private AdminService adminService;

    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        Admin admin1 = adminService.login(admin);
        System.out.println(admin1);
        return Result.success(admin1);
    }
}
