package com.yixian.service;

import com.yixian.entity.Grade;
import com.yixian.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixian.mapper.CourseMapper;
import com.yixian.mapper.GradeMapper;
import com.yixian.mapper.StudentMapper;
import org.apache.ibatis.javassist.runtime.Inner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;


    public void add(Grade grade) {
        System.err.println(grade);
        Grade dbGrade = gradeMapper.selectByCondition(grade);
        if (dbGrade != null) {  // 打过分了
            throw new CustomException("您已经打过分了");
        }
        // 根据课程名称和学生姓名查询出课程ID和学生ID
        Integer courseId = courseMapper.selectIdByName(grade.getCourse().getName());
        Integer studentId = studentMapper.selectIdByName(grade.getStudent().getName());
        grade.setCourseId(courseId);
        grade.setStudentId(studentId);
        gradeMapper.insert(grade);
    }

    public PageInfo<Grade> selectPage(Integer pageNum, Integer pageSize, String courseName, String studentName, Integer studentId, Integer teacherId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Grade> list = gradeMapper.selectAll(courseName, studentName, studentId, teacherId);
        return PageInfo.of(list);
    }

    public void update(Grade grade) {
        System.err.println(grade);
        grade.setCourseId(grade.getCourse().getId());
        grade.setStudentId(grade.getStudent().getId());
        gradeMapper.updateByPrimaryKey(grade);
    }

    public void deleteById(Integer id) {
        gradeMapper.deleteByPrimaryKey(Long.valueOf(id));
    }


    public List<Grade> selectAllById(Integer id) {
       List<Grade> gradeList = gradeMapper.selectAllById(id);
       return gradeList;
    }
}
