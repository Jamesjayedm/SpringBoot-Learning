package com.james.springbootdata.ret;

import lombok.Getter;

/**
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author jjr
 * @date 2018/10/14 11:42
 */
@Getter
public enum RetCode {


    // 成功
    SUCCESS(200,"成功"),

    // 失败
    FAIL(400,"失败"),

    // 未认证（签名错误）
    UNAUTHORIZED(401,"签名错误"),

    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器打酱油了，请稍后再试~");

    public int code;
    public String msg;

    RetCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
