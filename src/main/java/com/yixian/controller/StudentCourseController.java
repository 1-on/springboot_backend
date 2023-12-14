package com.yixian.controller;

import com.yixian.common.Result;
import com.yixian.entity.StudentCourse;
import com.yixian.service.StudentCourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             StudentCourse studentCourse) {
        PageInfo<StudentCourse> coursePageInfo = studentCourseService.selectPage(pageNum, pageSize, studentCourse);
        return Result.success(coursePageInfo);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        studentCourseService.deleteById(id);
        return Result.success();
    }
}
