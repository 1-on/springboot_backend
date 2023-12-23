package com.yixian.mapper;

import com.yixian.entity.Course;

import java.util.List;

/**
 * @author jiangfei
 * @description 针对表【course(课程信息)】的数据库操作Mapper
 * @createDate 2023-12-14 20:08:12
 * @Entity com.yixian.entity.Course
 */
public interface CourseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectAll(String name, String no, String teacherName);

    Integer selectIdByName(String name);

    List<Course> selectCourseNum(Integer id);
}
