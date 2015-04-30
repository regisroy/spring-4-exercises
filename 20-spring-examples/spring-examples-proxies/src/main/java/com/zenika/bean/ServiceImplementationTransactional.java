package com.zenika.bean;

import org.springframework.transaction.annotation.Transactional;


public class ServiceImplementationTransactional implements IServiceTransactional {

    @Transactional
    public String executeTransactional() {
        return "SUCCESS";
    }
}
