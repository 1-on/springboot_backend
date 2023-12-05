package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<Course> coursePageInfo = courseService.selectPage(pageNum, pageSize);
        return Result.success(coursePageInfo);
    }
}
