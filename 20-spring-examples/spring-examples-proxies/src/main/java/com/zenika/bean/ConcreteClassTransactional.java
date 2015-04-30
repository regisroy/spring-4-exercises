package com.zenika.bean;

import org.springframework.transaction.annotation.Transactional;


public class ConcreteClassTransactional {

    @Transactional
    public String executeTransactional() {
        return "SUCCESS";
    }
}
