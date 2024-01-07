package org.example.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class User {
    /**
     * 用户名，长度为4-10位
     */
    @NotBlank( message = "用户名不能为空" )
    @Length( min = 4, max = 10, message = "用户名长度为4-10位" )
    private String username;
    
    /**
     * 手机号，长度为11位，正则表达判断
     */
    @NotBlank( message = "手机号不能为空" )
    @Pattern( regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确" )
    private String phone;
}
