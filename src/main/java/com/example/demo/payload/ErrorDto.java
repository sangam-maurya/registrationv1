package com.example.demo.payload;

import java.util.Date;

public class ErrorDto {
    private String message;
    private Date date;
    private String url;

    public ErrorDto(String message, Date date, String url) {

        this.message = message;
        this.date = date;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
