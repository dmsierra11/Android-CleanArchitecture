package com.fernandocejas.android10.sample.domain;

/**
 * Created by IT on 23/05/2017.
 */

public class LoginResponse {
    private String message;
    private int code;

    public LoginResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
