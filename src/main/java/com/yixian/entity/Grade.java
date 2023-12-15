package com.yixian.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 成绩表
 * @TableName grade
 */
@Data
public class Grade implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 学生ID
     */
    private Integer studentId;

    /**
     * 分数
     */
    private Double score;

    /**
     * 评语
     */
    private String comment;

    /**
     * 学生反馈
     */
    private String feedback;

    private Course course;
    private Student student;

    private static final long serialVersionUID = 1L;
}