package com.yixian.mapper;

import com.yixian.entity.Account;
import com.yixian.entity.Student;
import com.yixian.entity.Teacher;

import java.util.List;

/**
 * @author jiangfei
 * @description 针对表【teacher】的数据库操作Mapper
 * @createDate 2023-12-14 19:54:13
 * @Entity com.yixian.entity.Teacher
 */
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher selectByUserName(String username);

    List<Student> selectAll(Teacher teacher);

    Teacher selectTeacherByName(String name);
}
