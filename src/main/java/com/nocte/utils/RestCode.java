package com.nocte.utils;

public enum RestCode {
    SUCCESS(200, "success"),
    ERROR(500, "error"),
    UNDEFINED_ERROR(-1, "未知错误"),
    EMPTY(1001, "参数为空");

    int code;
    String msg;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
