package com.example.project03.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用类
 *
 * @author fly
 */
@Data
@ApiModel( "通用类返回" )
public class JsonResult {
    /*状态码*/
        @ApiModelProperty( "状态码" )
        private Integer code;
        /*响应消息*/
        @ApiModelProperty( "响应消息" )
        private String message;
        /*响应是否成功标志*/
        @ApiModelProperty( "响应是否成功标志" )
        private boolean success;
        /*响应的数据(添加多个数据)*/
        @ApiModelProperty( "响应的数据(添加多个数据)" )
        private Map<String, Object> data = new HashMap<>();

    /**
     * 响应成功函数
     *
     * @return 第 11 页 共 34 页
     */
    public static JsonResult success() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(MsgEnum.SUCCESS.getCode());
        jsonResult.setMessage("响应成功");
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    /**
     * 响应失败函数
     *
     * @return
     */
    public static JsonResult fail() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(MsgEnum.FAILED.getCode());
        jsonResult.setMessage("响应失败");
        jsonResult.setSuccess(false);
        return jsonResult;
    }

    /**
     * 添加响应数据
     *
     * @return
     */
    public JsonResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 修改状态码
     *
     * @return
     */
    public JsonResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @return
     */
    public JsonResult mess(String str) {
        this.setMessage(str);
        return this;
    }
}