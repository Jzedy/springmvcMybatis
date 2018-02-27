package com.cn.jzedy.base.response;

import java.util.Map;

/**
 * Created by Jzedy on 2018/2/27
 */
public class ResponseData {
    private String code;
    private String message;
    private Map<String,Object> data;

    public ResponseData() {
    }

    public ResponseData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static ResponseData ok() {
        return new ResponseData("200", "操作成功");
    }
}
