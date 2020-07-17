package com.nocte.interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Object handleException(Exception e) {
        log.error("服务器出错", e);
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        JSONObject jsonObject = new JSONObject();
        System.out.println(msg);
        jsonObject.put("message", msg);
        jsonObject.put("code", 500);
        return jsonObject;
    }
}
