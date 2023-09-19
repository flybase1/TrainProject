package com.example.project01.pojo.request;

import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNum;
    private Integer pageSize;
}
