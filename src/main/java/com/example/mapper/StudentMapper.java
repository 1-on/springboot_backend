package com.example.mapper;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("select * from student where username = #{username}")
    Student selectByUserName(String username);

    @Insert("insert into student (username, password, name, sex, phone, email, birth, awatar, role) " +
            "VALUES (#{username}, #{password}, #{name}, #{sex}, #{phone}, #{email}, #{birth}, #{awatar}, #{role})")
    void insert(Student student);
}
