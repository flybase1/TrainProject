package com.example.project01.pojo.url;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties( prefix = "service.url" )
public class ServiceUrl {

    private String studentUrl;

    private String orderUrl;
}
