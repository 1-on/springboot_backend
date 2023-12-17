package com.yixian.service;

import com.yixian.entity.Account;
import com.yixian.exception.CustomException;
import com.yixian.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Account login(Account account) {
        Account dbAdmin = adminMapper.selectByUserName(account.getUsername());
        if (dbAdmin == null) {
            // 没有账号
            throw new CustomException("账号或密码错误");
        }
        // 比较密码
        if (!Objects.equals(dbAdmin.getPassword(), account.getPassword())) {
            throw new CustomException("账号或密码错误");
        }
        return dbAdmin;
    }
}
