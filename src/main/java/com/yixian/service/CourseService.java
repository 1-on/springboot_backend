package com.yixian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixian.entity.Course;
import com.yixian.entity.Teacher;
import com.yixian.exception.CustomException;
import com.yixian.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherService teacherService;

    // total查询总数 list是数据列表
    // pageNum 当前的页码，
    // pageSize 每页的个数
    public PageInfo<Course> selectPage(Integer pageNum, Integer pageSize, String name, String no, String teacherName) {

        PageHelper.startPage(pageNum, pageSize);
        List<Course> courseList = courseMapper.selectAll(name, no, teacherName);
        return PageInfo.of(courseList);
    }


    public void add(Course course) {
        System.err.println(course);
        Teacher teacher = teacherService.selectTeacherByName(course.getTeacher().getName());
        if (teacher == null) {
            throw new CustomException("没有该教师");
        }
        course.setTeacher(teacher);
        courseMapper.insert(course);
    }

    public void updateById(Course course) {
        Teacher teacher = teacherService.selectTeacherByName(course.getTeacher().getName());
        if (teacher == null) {
            System.err.println("错误");
            throw new CustomException("没有该教师");
        }
        course.setTeacher(teacher);
        courseMapper.updateByPrimaryKey(course);
    }

    public void deleteById(Integer id) {
        courseMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    public List<Course> selectCourseNum(Integer id) {
        List<Course> courseList = courseMapper.selectCourseNum(id);
        for (Course course : courseList) {
            if (course.getHaveGradeNumber() == 0) {
                course.setPassRate(100.0);
            } else {
                course.setPassRate(((double) course.getPassNumber() / course.getHaveGradeNumber()) * 100);
            }
            System.err.println(course);
        }
        return courseList;
    }
}
