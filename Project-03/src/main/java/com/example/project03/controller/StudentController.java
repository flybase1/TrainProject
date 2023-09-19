package com.example.project03.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.project03.domain.Student;
import com.example.project03.service.StudentService;
import com.example.project03.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@Api( tags = "学生管理" )
@RequestMapping( "/student" )
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping( "/all" )
    @ApiOperation( value = "查询所有学生", notes = "查询所有学生" )
    public JsonResult allStudentList() {
        List<Student> list = studentService.list();
        return JsonResult.success().data("studentList", list);
    }

    @GetMapping( "/all/page" )
    @ApiOperation( value = "分页查询所有学生", notes = "分页查询所有学生" )
    public JsonResult allStudentListPage(
            @RequestParam( value = "pageNum", defaultValue = "1" ) Integer pageNum,
            @RequestParam( value = "pageSize", defaultValue = "10" ) Integer pageSize,
            @RequestParam( defaultValue = "" ) String queryName) {
        Page<Student> studentPage = studentService.page(new Page<>(pageNum, pageSize, true), new QueryWrapper<Student>().like("name", queryName).orderBy(false, false, "id"));
        return JsonResult.success().data("studentPage", studentPage);
    }


    /**
     * 保存
     *
     * @param student
     * @return
     */
    @PostMapping( "/save" )
    @ApiOperation( value = "保存学生", notes = "保存学生" )
    public JsonResult studentSave( Student student) {
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        boolean save = studentService.save(student);
        return JsonResult.success().data("save", save);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation( value = "删除学生", notes = "删除学生" )
    @DeleteMapping( "/deleteStudent" )
    public JsonResult studentDelete(Integer id) {
        boolean b = studentService.removeById(id);
        return JsonResult.success().data("delete", b);
    }

    /**
     * 更新
     * @param student
     * @return
     */
    @ApiOperation( value = "更新学生", notes = "更新学生" )
    @PutMapping( "/update" )
    public JsonResult studentUpdate(Student student) {
        student.setUpdateTime(new Date());
        boolean update = studentService.update(student, new QueryWrapper<Student>().eq("id", student.getId()));
        return JsonResult.success().data("update", update);
    }

    /**
     * 获取
     * @param id
     * @return
     */
    @GetMapping( "/get" )
    @ApiOperation( value = "获取学生", notes = "获取学生" )
    public JsonResult studentGet(Integer id) {
        Student student = studentService.getById(id);
        return JsonResult.success().data("student", student);
    }

}
