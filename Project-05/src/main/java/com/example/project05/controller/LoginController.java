package com.example.project05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @GetMapping( "/login" )
    public String login() {
        return "login";
    }

    @GetMapping( "/main" )
    public String main() {
        return "main";
    }

    @GetMapping( "/logout" )
    public String logout() {
        return "login";
    }

}
