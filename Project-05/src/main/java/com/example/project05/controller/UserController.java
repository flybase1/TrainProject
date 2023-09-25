package com.example.project05.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping( "/admin" )
    public String admin() {
        return "admin 角色访问";
    }

    //@PreAuthorize("hasAnyRole('user')") // 只能 user 角色才能访问该方法
    @GetMapping( "/user" )
    public String user() {
        return "user 角色访问";
    }

    //@PreAuthorize("hasAnyRole('dba')") // 只能 admin 角色才能访问该方法
    @GetMapping( "/dba" )
    public String dba() {
        return "dba 角色访问";
    }
}
