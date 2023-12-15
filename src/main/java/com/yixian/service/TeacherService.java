package com.yixian.service;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixian.common.RoleEnum;
import com.yixian.entity.Account;
import com.yixian.entity.Student;
import com.yixian.entity.Teacher;
import com.yixian.exception.CustomException;
import com.yixian.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    public Account login(Account account) {
        Account dbTeacher = teacherMapper.selectByUserName(account.getUsername());
        if (dbTeacher == null) {
            // 没有账号
            throw new CustomException("账号或密码错误");
        }
        // 比较密码
        if (!Objects.equals(dbTeacher.getPassword(), account.getPassword())) {
            throw new CustomException("账号或密码错误");
        }
        return dbTeacher;
    }

    public PageInfo<Student> selectPage(Integer pageNum, Integer pageSize, Teacher teacher) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = teacherMapper.selectAll(teacher);
        return PageInfo.of(studentList);
    }

    public void updateById(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    public void add(Teacher teacher) {
        Teacher dbTeacher = (Teacher) teacherMapper.selectByUserName(teacher.getUsername());
        if (dbTeacher != null) {  // 已有同名账号
            throw new CustomException("账号已存在");
        }
        if (ObjectUtil.isEmpty(teacher.getName())) {
            teacher.setName(teacher.getUsername());
        }
        teacher.setRole(RoleEnum.TEACHER.name());
        teacherMapper.insert(teacher);
    }

    public void deleteById(Integer id) {
        teacherMapper.deleteByPrimaryKey(Long.valueOf(id));
    }


    public Teacher selectTeacherByName(String name) {
        return teacherMapper.selectTeacherByName(name);
    }
}
