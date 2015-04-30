package com.zenika.bean;

public class ServiceImplementationNotTransactional implements IServiceNotTransactional {

    public String doService() {
        return "SUCCESS";
    }

}
