package com.example.project01.controller;

import com.example.project01.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/exception" )
@Slf4j
@Api("异常处理")
public class ExceptionController {

    @PostMapping( "/testRequiredParam" )
    public JsonResult test(@RequestParam( "pName" ) String pName, @RequestParam( "pCode" ) String pCode) {
        log.info("商品名称：{}", pName);
        log.info("商品编号：{}", pCode);
        return JsonResult.success();
    }
}

