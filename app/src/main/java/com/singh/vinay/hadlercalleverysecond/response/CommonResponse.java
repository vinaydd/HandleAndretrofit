package com.singh.vinay.hadlercalleverysecond.response;

/**
 * Created by root on 2/2/17.
 */
public class CommonResponse {
    private String status;
    private String message;
    private String code;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
