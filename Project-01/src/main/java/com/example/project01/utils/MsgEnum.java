package com.example.project01.utils;

public enum MsgEnum {

    /**
     * 成功
     */
    SUCCESS(0, "请求成功"),
    /**
     * 失败
     */
    FAILED(1, "请求失败"),
    /**
     * 参数异常
     */
    PARMETER_EXCEPTION(102, "参数异常!"),
    /**
     * 等待超时
     */
    SERVICE_TIME_OUT(103, "服务调用超时！"),
    /**
     * 参数过大
     */
    PARMETER_BIG_EXCEPTION(104, "输入的图片数量不能超过 50 张!"),
    /**
     * 除数不能为零
     */
    UNEXPECTED_ARRAY_EXCEPTION(105, "除数不能为 0！"),
    /**
     * 500 :
     * 一劳永逸的提示也可以在这定义
     */
    UNEXPECTED_EXCEPTION(500, "系统发生异常，请联系管理员！");
// 还可以定义更多的业务异常
    /**
     * 消息码
     */
    private Integer code;
    /**
     * 消息内容
     */
    private String msg;

    private MsgEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
