package com.example.project01.controller;

import com.example.project01.pojo.url.ServiceUrl;
import com.example.project01.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/url")
public class PropertiesTestController {
    @Resource
    private ServiceUrl serviceUrl;

    @GetMapping( "/get" )
    public JsonResult getAllUrlByProperties() {
        log.info("studentUrl======>"+serviceUrl.getStudentUrl());
        log.info("orderUrl======>"+ serviceUrl.getOrderUrl());
        return JsonResult.success().code(10000).data("url",serviceUrl.getOrderUrl());
    }
}
