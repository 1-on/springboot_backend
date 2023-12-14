package com.yixian.mapper;

import com.yixian.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student where username = #{username}")
    Student selectByUserName(String username);

    @Insert("insert into student (username, password, name, sex, phone, email, birth, awatar, role) " +
            "VALUES (#{username}, #{password}, #{name}, #{sex}, #{phone}, #{email}, #{birth}, #{awatar}, #{role})")
    void insert(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteById(Integer id);

    @Update("update student set username =#{username},password=#{password},name=#{name},phone=#{phone}," +
            "email=#{email},sex=#{sex},awatar=#{awatar} where id = #{id}")
    void updateById(Student student);

    @Select("select * from student where username like concat('%',#{username},'%') " +
            "and name like concat('%',#{name},'%') order by id desc")
    List<Student> selectAll(Student student);
}
