package com.appareldiving.adidasdataparsing.response;

import org.springframework.http.HttpStatus;

public class UnsupportedNumberOfOffers {

    private String message;

    private int statusCode;

    public UnsupportedNumberOfOffers(String message) {
        this.message = "Quantity must be more than 0 and less than 1000. Required quantity is [" + message + "].";
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public UnsupportedNumberOfOffers() {
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
