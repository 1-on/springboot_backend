package com.yixian.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 课程信息
 *
 * @TableName course
 */
@Data
public class Course implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程编号
     */
    private String no;

    /**
     * 课程描述
     */
    private String descr;

    /**
     * 课时多少
     */
    private String times;

    /**
     * 老师ID
     */
    private Integer teacherId;

    private Teacher teacher;

    private static final long serialVersionUID = 1L;
}