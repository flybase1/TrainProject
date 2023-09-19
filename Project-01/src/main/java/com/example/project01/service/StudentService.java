package com.example.project01.service;


import com.example.project01.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 展示所有的学生
     * @return
     */
    List<Student> getAllStudent();

    /**
     * 增加学生
     * @param student
     * @return
     */
    boolean insertStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    boolean deleteStudentById(int id);

    /**
     * 更新学生
     * @param student
     * @return
     */
    void updateStudent(Student student);

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    Student getByStudentId(int id);


    List<Student> getStudentByName(String name);

}
