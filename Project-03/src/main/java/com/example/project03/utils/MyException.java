package com.example.project03.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode( callSuper = true )
@Data
public class MyException extends RuntimeException {
    private Integer code;
    private String message;

    public MyException(MsgEnum msgEnum) {
        this.code = msgEnum.getCode();
        this.message = msgEnum.getMsg();
    }

}
