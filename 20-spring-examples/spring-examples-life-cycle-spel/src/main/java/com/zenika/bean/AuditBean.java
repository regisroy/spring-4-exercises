package com.zenika.bean;

public class AuditBean {

    private String message = "";

    @Override
    public String toString() {
        return "AuditBean:" + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
