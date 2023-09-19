package com.example.fly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fly.domain.Student;
import com.example.fly.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping( "/student" )
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping( "/all" )
    public String allStudentList(Model model) {
        List<Student> list = studentService.list();
        model.addAttribute("studentList", list);
        return "student";
    }

    @GetMapping( "/all/page" )
    public String allStudentListPage(Model model,
                                     @RequestParam( value = "pageNum", defaultValue = "1" ) Integer pageNum,
                                     @RequestParam( value = "pageSize", defaultValue = "10" ) Integer pageSize,
                                     @RequestParam( defaultValue = "" ) String queryName) {

        Page<Student> studentPage = studentService.page(new Page<>(pageNum, pageSize, true), new QueryWrapper<Student>().like("name", queryName));
        model.addAttribute("studentPageInfo", studentPage);
        return "student";
    }

    /**
     * 保存
     *
     * @param student
     * @return
     */
    @PostMapping( "/save" )
    public String studentSave(Student student) {
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        studentService.save(student);
        return "redirect:/student/all/page";
    }

    @GetMapping( "/deleteStudent" )
    public String studentDelete(Integer id) {
        studentService.removeById(id);
        return "redirect:/student/all/page";
    }

    @PostMapping( "/update" )
    public String studentUpdate(Student student) {
        student.setUpdateTime(new Date());
        studentService.update(student, new QueryWrapper<Student>().eq("id", student.getId()));
        return "redirect:/student/all/page";
    }

    @GetMapping( "/get" )
    public String studentGet(Integer id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "updateStudent";
    }

}
