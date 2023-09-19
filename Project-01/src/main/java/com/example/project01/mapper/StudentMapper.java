package com.example.project01.mapper;


import com.example.project01.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 查询所有的学生
     *
     * @return
     */
    List<Student> selectStudentList();


    /**
     * 条件查询
     * @param queryName
     * @return
     */
    List<Student> selectStudentListQuery(String queryName);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    boolean insertStudent(Student student);


    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    boolean deleteStudent(int id);

    /**
     * 根据id查找学生
     *
     * @param id
     * @return
     */
    Student getStudentById(int id);

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    void updateStudent(Student student);


}
