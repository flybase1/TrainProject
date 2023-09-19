package com.example.project01.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project01.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {
    @Resource
    private StudentServiceImpl studentService;

    @Test
    void list() {
        studentService.getAllStudent().stream().forEach(System.out::println);
    }

    @Test
    void getAllStudent() {
    }

    @Test
    void insertStudent() {
    }

    @Test
    void deleteStudentById() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void getByStudentId() {
    }

    @Test
    void getStudentByName() {
        List<Student> wz = studentService.getStudentByName("wz");
        wz.stream().forEach(System.out::println);
    }


    @Test
    void testList() {
        studentService.list().stream().forEach(System.out::println);
    }


    @Test
    void testPage() {
        Page<Student> studentPage = studentService.page(new Page<>(1, 3));
        System.out.println(studentPage);
    }
}