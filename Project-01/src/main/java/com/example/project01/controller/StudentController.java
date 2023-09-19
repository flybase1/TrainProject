package com.example.project01.controller;

import com.example.project01.pojo.Student;
import com.example.project01.service.StudentService;
import com.example.project01.utils.JsonResult;
import com.example.project01.utils.MsgEnum;
import com.example.project01.utils.MyException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生列表展示
 *
 * @author fly
 */
@Slf4j
@RestController
@RequestMapping( "/student" )
@Api( tags = "学生列表展示" )
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 列表展示
     *
     * @return
     */
    @GetMapping( "/all" )
    public JsonResult getAllStudents() {
        return JsonResult.success().data("userList", studentService.getAllStudent());
    }

    /**
     * 分页展示
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping( "/all/page" )
    public JsonResult getAllStudentsByPage(@ApiParam( "页数" ) Integer page, @ApiParam( "条数" ) Integer pageSize) {
        if (page == null || page <= 0 || pageSize == null || pageSize <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }

        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        List<Student> studentList = studentService.getAllStudent();
        PageInfo<Student> studentPageInfo = new PageInfo<Student>(studentList);

        log.info("studentPageInfo:{}", studentPageInfo);

        return JsonResult.success().data("userPage", studentPageInfo);
    }

    /**
     * 插入
     *
     * @param student
     * @return
     */
    @PostMapping( "/save" )
    public JsonResult insertStudent(@RequestBody Student student) {
        log.info("save student:{}", student);
        return JsonResult.success().code(10000).data("save", studentService.insertStudent(student));
    }

    /**
     * 根据id进行更新
     *
     * @param student
     */
    @PostMapping( "/update" )
    public void updateStudent(@RequestBody Student student) {
        if (student.getName() == null) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }

        log.info("update student:{}", student);
        studentService.updateStudent(student);
    }

    /**
     * 根据id进行删除
     *
     * @param id
     * @return
     */
    @GetMapping( "/delete/{id}" )
    public JsonResult deleteStudent(@ApiParam( "删除学生id" ) @PathVariable( "id" ) Integer id) {
        if (id == null || id <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }
        log.info("delete student id:{}", id);
        return JsonResult.success().code(10000).data("delete", studentService.deleteStudentById(id));
    }

    /**
     * 根据id获取哦用户信息
     *
     * @param id
     * @return
     */
    @ApiOperation( value = "根据学生id获取学生信息" )
    @GetMapping( "/get/{id}" )
    public JsonResult getStudentById(@ApiParam( "根据id获取学生信息" ) @PathVariable( "id" ) Integer id) {
        if (id == null || id <= 0) {
            throw new MyException(MsgEnum.PARMETER_EXCEPTION);
        }

        log.info("get student id:{}", id);
        return JsonResult.success().code(10000).data("user", studentService.getByStudentId(id));
    }
}
