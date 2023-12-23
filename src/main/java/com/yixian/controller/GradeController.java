package com.yixian.controller;

import com.yixian.common.Result;
import com.yixian.entity.Course;
import com.yixian.entity.Grade;
import com.yixian.service.GradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/add")
    public Result add(@RequestBody Grade grade) {
        gradeService.add(grade);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Grade grade) {
        gradeService.update(grade);
        return Result.success();
    }


    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "courseName", required = false) String courseName,
                             @RequestParam(name = "studentName", required = false) String studentName,
                             @RequestParam(name = "studentId", required = false) Integer studentId,
                             @RequestParam(name = "teacherId", required = false) Integer teacherId) {
        PageInfo<Grade> gradePageInfo = gradeService.selectPage(pageNum, pageSize, courseName, studentName, studentId,teacherId);
        return Result.success(gradePageInfo);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        gradeService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectCourseNum(@RequestParam(name = "id",required = false) Integer id) {
        List<Grade> gradeList = gradeService.selectAllById(id);
        return Result.success(gradeList);
    }

}
