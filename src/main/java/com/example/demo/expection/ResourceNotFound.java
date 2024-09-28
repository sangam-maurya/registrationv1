package com.example.demo.expection;

public class ResourceNotFound extends  RuntimeException{
    public ResourceNotFound(String msg) {
    super(msg);
    }
}
