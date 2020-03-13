package com.appareldiving.adidasdataparsing.response;

import org.springframework.http.HttpStatus;

public class UnsupportedParser {

    private String message;

    private int statusCode;

    public UnsupportedParser(String message) {
        this.message = "Parser [" + message + "] is not supported.";
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public UnsupportedParser() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
