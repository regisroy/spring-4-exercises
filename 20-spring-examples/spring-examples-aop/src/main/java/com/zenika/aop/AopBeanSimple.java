package com.zenika.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class AopBeanSimple extends AbstractAopBean {

    public AopBeanSimple(StringBuilder records) {
        super(records);
    }

    public void log(JoinPoint joinPoint) {
        processLog(joinPoint);
    }

    public Object measure(ProceedingJoinPoint proceedingJoinPoint) {
        return processMeasure(proceedingJoinPoint);
    }

}
