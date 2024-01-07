package com.example.demo;

import com.fly.flyapiclientsdk.client.FlyApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping( "/test" )
@RestController
public class test {
    @Resource
    private FlyApiClient flyApiClient;

    @GetMapping( "/test" )
    public String test() {
        String daySayings = flyApiClient.getFamousSayings();
        return daySayings;
    }


}
