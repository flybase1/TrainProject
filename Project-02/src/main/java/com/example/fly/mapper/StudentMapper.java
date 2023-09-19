package com.example.fly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fly.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-09-15 14:56:59
* @Entity com.example.fly.domain.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




