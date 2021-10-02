package com.example.test.micro.stubs;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message_constructor) {
        this.message=message_constructor;

    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
