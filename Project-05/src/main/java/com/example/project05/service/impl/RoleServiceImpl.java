package com.example.project05.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project05.entity.Role;
import com.example.project05.service.RoleService;
import com.example.project05.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-09-25 15:59:51
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




