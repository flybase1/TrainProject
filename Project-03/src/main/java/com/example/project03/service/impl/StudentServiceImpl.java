package com.example.project03.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project03.domain.Student;
import com.example.project03.mapper.StudentMapper;
import com.example.project03.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2023-09-15 14:57:00
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}




