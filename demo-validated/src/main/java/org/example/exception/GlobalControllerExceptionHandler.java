package org.example.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 拦截@RequstBody注解的参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler( MethodArgumentNotValidException.class )
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        // 处理验证错误
        return bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
    }


    /**
     * 拦截不加@RequstBody注解的参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler( BindException.class )
    public String handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        // 处理验证错误
        return bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
    }


    /**
     * 拦截@RequstParam注解的参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler( {ConstraintViolationException.class} )
    public String handleMethodArgumentNotValidException(ConstraintViolationException e) {
        // 处理验证错误
        return e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(","));
    }

}
