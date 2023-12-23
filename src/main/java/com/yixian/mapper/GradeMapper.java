package com.yixian.mapper;

import com.yixian.entity.Grade;

import java.util.List;

/**
 * @author jiangfei
 * @description 针对表【grade(成绩表)】的数据库操作Mapper
 * @createDate 2023-12-14 20:08:17
 * @Entity com.yixian.entity.Grade
 */
public interface GradeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    Grade selectByCondition(Grade grade);

    List<Grade> selectAll(String courseName, String studentName, Integer studentId, Integer teacherId);

    List<Grade> selectAllById(Integer id);

}
