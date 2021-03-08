package com.mjf.commonutils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 * 统一响应格式
 *
 * @author LDlim
 * @date 2020/12/27 13:48
 */
@Data
public class ResponseObject implements Serializable {

    private Boolean isSuccess;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();


    private ResponseObject() {

    }

    /**
     * 响应成功
     *
     * @return
     */
    public static ResponseObject responseSuccess() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setIsSuccess(true);
        responseObject.setCode(ResultCode.SUCCESS);
        return responseObject;

    }

    /**
     * 响应失败
     *
     * @return
     */
    public static ResponseObject responseError() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setIsSuccess(false);
        responseObject.setCode(ResultCode.ERROR);
        return responseObject;
    }


    public ResponseObject setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResponseObject setMessage(String string) {
        this.message = string;
        return this;
    }


}
