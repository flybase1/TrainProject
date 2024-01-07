package com.example.project07;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping( "/test" )
public class TestController {
    @Resource
    private Test test;

    @RequestMapping( "/1" )
    public BaseResponse<ZelinAIResponse> test1(@RequestBody ZelinAIRequest zelinAIRequest) {
        return test.doChat(zelinAIRequest);
    }
}
