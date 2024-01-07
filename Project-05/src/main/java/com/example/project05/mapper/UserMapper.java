package com.example.project05.mapper;

import com.example.project05.entity.Role;
import com.example.project05.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-09-25 15:58:15
 * @Entity com.example.project05.entity.User
 */
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer id);
}




