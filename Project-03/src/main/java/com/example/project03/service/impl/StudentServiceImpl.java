package com.example.project03.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project03.domain.Student;
import com.example.project03.mapper.StudentMapper;
import com.example.project03.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2023-09-15 14:57:00
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Transactional
    public List<Student> getAllStudent() {
        Student student1 = new Student();
        student1.setName("张三");

        Student student2 = new Student();
        student2.setName("李四");

        this.save(student1);

        int i = 10 / 0;

        this.save(student2);
        return this.list();
    }

}




