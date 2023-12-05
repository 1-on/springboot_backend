package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Student;
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

    public void register(Account account) {
        Student student = new Student();
        student.setUsername(account.getUsername());  // 账号
        student.setPassword(account.getPassword());  // 密码
        this.add(student);
    }

    // 新增方法
    private void add(Student student) {
        Student dbStudent = studentMapper.selectByUserName(student.getUsername());
        if (dbStudent != null) {  // 已有同名账号
            throw new CustomException("账号已存在");
        }
        if (ObjectUtil.isEmpty(student.getName())) {
            student.setName(student.getUsername());
        }
        student.setRole(RoleEnum.STUDENT.name());
        studentMapper.insert(student);
    }
}
