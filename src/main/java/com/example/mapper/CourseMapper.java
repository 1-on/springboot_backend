package com.example.mapper;

import com.example.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select * from course where name like concat('%',#{name},'%') " +
            "and no like concat('%',#{no},'%') and teacher like concat('%',#{teacher},'%') " +
            "order by id desc  ")
    List<Course> selectAll(Course course);
}
