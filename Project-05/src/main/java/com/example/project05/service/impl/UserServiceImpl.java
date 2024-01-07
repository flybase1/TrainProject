package com.example.project05.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project05.entity.Role;
import com.example.project05.entity.User;
import com.example.project05.entity.UserRole;
import com.example.project05.service.UserService;
import com.example.project05.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-09-25 15:58:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {
    @Resource
    private UserRoleServiceImpl userRoleService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User one = this.getOne(new QueryWrapper<User>().eq("username", username));
//        User user = userMapper.loadUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
        if (one == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<UserRole> roleList = userRoleService.list(new QueryWrapper<UserRole>().eq("uid", one.getId()));
        roleList.forEach(userRole -> {
            Integer rid = userRole.getRid();
            List<Role> roles = roleService.list(new QueryWrapper<Role>().eq("id", rid));
            one.setRoles(roles);
        });
        // user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        //return user;
        return one;
    }
}




