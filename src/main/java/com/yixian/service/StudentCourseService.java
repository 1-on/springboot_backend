package com.yixian.service;

import com.yixian.entity.StudentCourse;
import com.yixian.exception.CustomException;
import com.yixian.mapper.StudentCourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    @Autowired
    StudentCourseMapper studentCourseMapper;


    public void add(StudentCourse studentCourse) {
        StudentCourse dbStudentCourse = studentCourseMapper.selectByCondition(studentCourse);// 通过学生ID和课程ID做一次查询的筛选，查看学生之前是否选过该课程
        if (dbStudentCourse != null) {
            throw new CustomException("您已经选过该课程了");
        }
        studentCourseMapper.insert(studentCourse);
    }

    public PageInfo<StudentCourse> selectPage(Integer pageNum, Integer pageSize, StudentCourse studentCourse) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentCourse> list = studentCourseMapper.selectAll(studentCourse);
        return PageInfo.of(list);
    }

    public void deleteById(Integer id) {
        studentCourseMapper.deleteById(id);
    }
}
