package com.example.project03.service.impl;

import com.example.project03.domain.Student;
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
    void getAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();
        allStudent.stream().forEach(System.out::println);
    }
}