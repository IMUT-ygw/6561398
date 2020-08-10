package com.imut.compoent;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/13 11:44
 */
public class MyException extends  RuntimeException {
    public String msg;
    public String code;

    public MyException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
