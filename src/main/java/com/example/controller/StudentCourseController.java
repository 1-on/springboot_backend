package com.example.controller;

import com.example.common.Result;
import com.example.entity.StudentCourse;
import com.example.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping("/add")
    public Result add(@RequestBody StudentCourse studentCourse) {
        studentCourseService.add(studentCourse);
        return Result.success();
    }
}
