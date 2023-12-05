package com.example.service;

import com.example.entity.Admin;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Admin login(Admin admin) {
        Admin dbadmin = adminMapper.selectByUserName(admin.getUsername());
        if (dbadmin == null){
            // 没有账号
            throw new CustomException("账号或密码错误");
        }
        // 比较密码
        if(!Objects.equals(dbadmin.getPassword(), admin.getPassword())){
            throw new CustomException("账号或密码错误");
        }
        return dbadmin;
    }
}
