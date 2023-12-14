package com.yixian.mapper;

import com.yixian.entity.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GradeMapper {

    @Insert("insert into grade(course_id,student_id,score,comment,feedback)values " +
            "(#{courseId},#{studentId},#{score},#{comment},#{feedback})")
    void insert(Grade grade);

    List<Grade> selectAll(Grade grade);

    @Update("update grade set score = #{score},comment=#{comment},feedback=#{feedback} where id = #{id}")
    void update(Grade grade);

    @Select("select * from grade where student_id = #{studentId} and course_id=#{courseId}")
    Grade selectByCondition(Grade grade);

    @Delete("delete from grade where id = #{id}")
    void deleteById(Integer id);
}
