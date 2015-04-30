package com.zenika.aop;

import org.aspectj.lang.JoinPoint;


public class AopBeanSimple {

    public void log(JoinPoint joinPoint) {
        Object signature = joinPoint.getSignature();

        System.out.println("\n" + signature);
    }


}
