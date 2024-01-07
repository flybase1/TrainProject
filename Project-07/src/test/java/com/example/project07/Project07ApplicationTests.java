package com.example.project07;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Scanner;

@SpringBootTest
class Project07ApplicationTests {
    @Resource
    private com.example.project07.Test test;

    @Test
    void contextLoads() {
        ZelinAIRequest zelinAIRequest = new ZelinAIRequest();
        zelinAIRequest.setApp_id("dmjKWsbFjnhsbXhXQiW3qh");
        zelinAIRequest.setRequest_id("15464548417");
        zelinAIRequest.setUid("841894874897");

        zelinAIRequest.setContent("你是谁");
        String answer = String.valueOf(test.doChat(zelinAIRequest));
        System.out.println(answer);
    }

}
