package com.example.project01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PictureController {

    @RequestMapping( "/picture" )
    public String gotoHtmlIndex() {
        return "index";
    }

    @RequestMapping( "/404" )
    public String goto404() {
        return "404";
    }
}
