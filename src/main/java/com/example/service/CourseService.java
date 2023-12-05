package com.example.service;

import com.example.entity.Course;
import com.example.mapper.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    // total查询总数 list是数据列表
    // pageNum 当前的页码，
    // pageSize 每页的个数
    public PageInfo<Course> selectPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Course> courseList = courseMapper.selectAll();
        return PageInfo.of(courseList);
    }


}
