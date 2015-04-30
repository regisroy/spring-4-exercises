package com.zenika.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class AopBeanWithAnnotationsAround extends AbstractAopBean {

    public AopBeanWithAnnotationsAround(StringBuilder records) {
        super(records);
    }

    @Around("execution(* com.zenika..*.multiply(int))")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) {
        return processMeasure(proceedingJoinPoint);
    }
}
