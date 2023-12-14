package com.yixian.mapper;

import com.yixian.entity.StudentCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCourseMapper {

    @Insert("insert into student_course(name,no,student_id,course_id)values(#{name},#{no},#{studentId},#{courseId})")
    void insert(StudentCourse studentCourse);

    @Select("select * from student_course where student_id = #{studentId} and course_id=#{courseId}")
    StudentCourse selectByCondition(StudentCourse studentCourse);

//    @Select("select * from student_course where name like concat('%',#{name},'%') and no like concat('%',#{no},'%') and student_id=#{studentId}")
    List<StudentCourse> selectAll(StudentCourse studentCourse);

    @Delete("delete from student_course where id = #{id}")
    void deleteById(Integer id);
}
