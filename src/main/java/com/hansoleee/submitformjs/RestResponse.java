package com.hansoleee.submitformjs;

import lombok.Getter;

@Getter
public class RestResponse {

    private boolean success;
    private String message;
    private Object data;

    public RestResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RestResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
