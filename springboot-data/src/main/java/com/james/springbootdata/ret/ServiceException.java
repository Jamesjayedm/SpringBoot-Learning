package com.james.springbootdata.ret;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 业务类异常
 * @author jjr
 * @date 2018/11/14 14:30
 *
 */
@Data
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1213855733833039552L;

    private Integer code;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(RetCode retCode) {
        super(retCode.getMsg());
        this.code = retCode.getCode();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}


