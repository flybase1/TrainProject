package com.example.project05.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project05.entity.UserRole;
import com.example.project05.service.UserRoleService;
import com.example.project05.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-09-25 16:02:19
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




