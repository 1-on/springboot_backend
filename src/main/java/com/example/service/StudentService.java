package com.example.service;

import com.example.entity.Account;
import com.example.exception.CustomException;
import com.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Account login(Account account) {
        Account dbStudent = studentMapper.selectByUserName(account.getUsername());
        if (dbStudent == null) {
            // 没有账号
            throw new CustomException("账号或密码错误");
        }
        // 比较密码
        if (!Objects.equals(dbStudent.getPassword(), account.getPassword())) {
            throw new CustomException("账号或密码错误");
        }
        return dbStudent;
    }
}
