package com.yixian.service;

import cn.hutool.core.util.ObjectUtil;
import com.yixian.common.RoleEnum;
import com.yixian.entity.Account;
import com.yixian.entity.Student;
import com.yixian.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixian.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void add(Student student) {
        Student dbStudent = (Student) studentMapper.selectByUserName(student.getUsername());
        if (dbStudent != null) {  // 已有同名账号
            throw new CustomException("账号已存在");
        }
        if (ObjectUtil.isEmpty(student.getName())) {
            student.setName(student.getUsername());
        }
        student.setRole(RoleEnum.STUDENT.name());
        studentMapper.insert(student);
    }

    public void deleteById(Integer id) {
        studentMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    public void updateById(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    public PageInfo<Student> selectPage(Integer pageNum, Integer pageSize, Student student) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentMapper.selectAll(student);
        return PageInfo.of(studentList);
    }
}
