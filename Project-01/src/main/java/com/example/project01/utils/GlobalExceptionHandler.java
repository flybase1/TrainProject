package com.example.project01.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
@Slf4j
// 全局异常处理
public class GlobalExceptionHandler {

    @ExceptionHandler( MissingServletRequestParameterException.class )
    @ResponseStatus( value = HttpStatus.BAD_REQUEST )
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数", ex);
        return JsonResult.fail().code(MsgEnum.PARMETER_EXCEPTION.getCode()).mess("缺少必要的参数");
    }


    @ExceptionHandler( NullPointerException.class )
    @ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR )
    public JsonResult handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常", ex);
        return JsonResult.fail().code(MsgEnum.PARMETER_EXCEPTION.getCode()).mess("空指针异常");
    }
}
