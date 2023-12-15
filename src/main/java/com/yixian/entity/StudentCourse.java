package com.yixian.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 学生选课
 *
 * @TableName student_course
 */
@Data
public class StudentCourse implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 学生ID
     */
    private Integer studentId;

    /**
     * 课程ID
     */
    private Integer courseId;

    private Student student;

    private Course course;

    private Teacher teacher;

    private static final long serialVersionUID = 1L;
}