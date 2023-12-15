package com.yixian.mapper;

import com.yixian.entity.Account;
import com.yixian.entity.Student;

import java.util.List;

/**
* @author jiangfei
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-12-14 20:08:23
* @Entity com.yixian.entity.Student
*/
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByUserName(String username);

    List<Student> selectAll(Student student);

    Integer selectIdByName(String name);
}
