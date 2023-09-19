package com.example.fly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fly.domain.Student;
import com.example.fly.service.StudentService;
import com.example.fly.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-09-15 14:32:06
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




