package com.yixian.mapper;

import com.yixian.entity.StudentCourse;

import java.util.List;

/**
 * @author jiangfei
 * @description 针对表【student_course(学生选课)】的数据库操作Mapper
 * @createDate 2023-12-14 20:08:26
 * @Entity com.yixian.entity.StudentCourse
 */
public interface StudentCourseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);

    StudentCourse selectByCondition(StudentCourse studentCourse);

    List<StudentCourse> selectAll(String name, String no, Integer studentId, Integer teacherId);
}
