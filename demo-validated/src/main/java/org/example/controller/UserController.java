package org.example.controller;


import org.example.model.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RequestMapping( "/user" )
@RestController
@Validated
public class UserController {

    @PostMapping( "/addUser1" )
    public void addUser1(@Validated @RequestBody User user) {

    }

    @PostMapping( "/addUser2" )
    public void addUser2(@Validated User user) {

    }

    @PostMapping( "/addUser3" )
    public void addUser3(
            @NotBlank( message = "名称不能为空" )
            @Length( min = 4, max = 10, message = "用户名长度为4-10位" ) String username,
            @NotBlank( message = "手机号不能为空" )
            @Pattern( regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确" ) String phone) {

    }
}
