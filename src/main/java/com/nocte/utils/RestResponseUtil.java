package com.nocte.utils;

import static com.nocte.utils.RestCode.*;

public class RestResponseUtil {

    /**
     * 成功返回成功实体
     *
     * @param data 返回数据
     * @return
     */
    public static <T> RestResponse<T> success(T data) {

        RestResponse<T> restResponse = new RestResponse<T>();
        restResponse.setCode(SUCCESS.getCode());
        restResponse.setMessage(SUCCESS.getMsg());
        restResponse.setData(data);
        return restResponse;
    }

    /**
     * 创建一个响应实体类
     *
     * @param data 返回数据
     * @return
     */
    public static <T> RestResponse<T> createResponse(RestCode restCode, T data) {
        RestResponse<T> restResponse = new RestResponse<T>();
        restResponse.setCode(restCode.getCode());
        restResponse.setMessage(restCode.getMsg());
        restResponse.setData(data);
        return restResponse;
    }

    /**
     * 创建一个响应实体类
     *
     * @return
     */
    public static <T> RestResponse<T> createResponse(RestCode restCode) {
        RestResponse<T> restResponse = new RestResponse<T>();
        restResponse.setCode(restCode.getCode());
        restResponse.setMessage(restCode.getMsg());
        return restResponse;
    }

    /**
     * 成功返回成功实体
     * @return
     */
    public static RestResponse<Object> success() {
        return success(null);
    }

    /**
     * 错误返回实体
     *
     * @param code 错误码
     * @param msg 错误信息
     * @return
     */
    public static <T> RestResponse<T> error(int code, String msg) {
        RestResponse<T> restResponse = new RestResponse<T>();
        restResponse.setCode(code);
        restResponse.setMessage(msg);
        return restResponse;

    }
}
