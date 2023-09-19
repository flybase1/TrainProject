package com.example.project01.service.serviceImpl;


import com.example.project01.mapper.StudentMapper;
import com.example.project01.pojo.Student;
import com.example.project01.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;


    @Override
    public List<Student> getAllStudent() {
        return studentMapper.selectStudentList();
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insertStudent(student);

    }

    @Override
    public boolean deleteStudentById(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public Student getByStudentId(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentMapper.selectStudentListQuery(name);
    }
}
