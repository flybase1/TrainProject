package com.example.project01.controller;

import com.example.project01.pojo.Student;
import com.example.project01.service.StudentService;
import com.example.project01.utils.JsonResult;
import com.example.project01.utils.MsgEnum;
import com.example.project01.utils.MyException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping( "/studentShow" )
@Controller
@Slf4j
public class StudentShowController {
    @Resource
    private StudentService studentService;


    @GetMapping( "/show" )
    public String show(Model model) {
        model.addAttribute("name", "fly");
        return "student";
    }


    /**
     * 列表展示
     *
     * @return
     */
    @GetMapping( "/all" )
    public String getAllStudents(Model model) {
        List<Student> allStudent = studentService.getAllStudent();
        model.addAttribute("allStudent", allStudent);
        return "student";
    }


    /**
     * 插入
     *
     * @param student
     * @return
     */
    @PostMapping( "/addStudent" )
    public String insertStudent(Student student) {
        studentService.insertStudent(student);
        return "redirect:/studentShow/all/page";
    }


    /**
     * 根据id进行删除
     *
     * @param id
     * @return
     */
    @GetMapping( "/deleteStudent" )
    public String deleteStudent(Integer id) {
        if (id == null || id <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }
        log.info("delete student id:{}", id);
        boolean b = studentService.deleteStudentById(id);
        if (!b) {
            return "404";
        }
        return "redirect:/studentShow/all/page";
    }


    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @PostMapping( "/updateStudent" )
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/studentShow/all/page";
    }

    /**
     * 获取指定学生id的信息
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping( "/queryStudent" )
    public String studentShow(Integer id, Model model) {
        Student student = studentService.getByStudentId(id);
        model.addAttribute("student", student);
        return "studentShow";
    }


    /**
     * 分页展示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping( "/all/page" )
    public String getAllStudentsByPage(@ApiParam( "页数" ) @RequestParam( value = "page", defaultValue = "1" ) Integer page, @ApiParam( "条数" ) @RequestParam( value = "pageSize", defaultValue = "5" ) Integer pageSize, Model model,@RequestParam(value = "queryName",defaultValue = "") String queryName) {
        if (page == null || page <= 0 || pageSize == null || pageSize <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }

        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        List<Student> studentList = studentService.getStudentByName(queryName);
        model.addAttribute("studentList", studentList);
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList);
        model.addAttribute("total", studentPageInfo.getTotal());
        model.addAttribute("studentPageInfo", studentPageInfo);
        log.info("studentPageInfo:{}", studentPageInfo);
        return "student";
    }


    /**
     * 根据id获取哦用户信息
     *
     * @param id
     * @return
     */
    @GetMapping( "/get" )
    public String getStudentById(@RequestParam( value = "id" ) Integer id, Model model) {
        if (id == null || id <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }

        log.info("get student id:{}", id);
        Student student = studentService.getByStudentId(id);
        model.addAttribute("student", student);
        return "editStudent";
    }
}
