package com.yixian.controller;

import com.yixian.common.Result;
import com.yixian.entity.Course;
import com.yixian.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "no", required = false) String no,
                             @RequestParam(name = "teacher", required = false) String teacher) {
        PageInfo<Course> coursePageInfo = courseService.selectPage(pageNum, pageSize, name, no, teacher);
        return Result.success(coursePageInfo);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Course course) {
        courseService.add(course);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Course course) {
        System.err.println(course);
        courseService.updateById(course);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        courseService.deleteById(id);
        return Result.success();
    }

    // 查询课程信息 （选课人数、及格率）

    @GetMapping("/selectCourseNum")
    public Result selectCourseNum(@RequestParam(name = "id", required = false) Integer id) {
        List<Course> courseList = courseService.selectCourseNum(id);
        return Result.success(courseList);
    }
}
