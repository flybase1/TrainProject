package com.example.fly.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fly.domain.Student;
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
    void testList() {
        //fail("Not yet implemented");
        List<Student> list = studentService.list();
        list.stream().forEach(System.out::println);
    }

    @Test
    void testAdd() {
        Student student = new Student();
        student.setName("fly");
        boolean save = studentService.save(student);
        System.out.println(save);
    }


    @Test
    void testPage() {
        List<Student> records = studentService.page(new Page<>(2, 3)).getRecords();
        records.stream().forEach(System.out::println);
    }
}