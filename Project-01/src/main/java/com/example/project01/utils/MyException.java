package com.example.project01.utils;

import lombok.Data;

@Data
public class MyException extends RuntimeException {
    private Integer code;
    private String message;

    public MyException(MsgEnum msgEnum) {
        this.code = msgEnum.getCode();
        this.message = msgEnum.getMsg();
    }

}
