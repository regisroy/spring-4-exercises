package com.zenika.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AopBeanWithAnnotationsAroundAndBefore extends AbstractAopBean {

    public AopBeanWithAnnotationsAroundAndBefore(StringBuilder records) {
        super(records);
    }

    @Before("setMethod() or toStringMethod()")
    public void log(JoinPoint joinPoint) {
        processLog(joinPoint);
    }

    @Around("execution(* com.zenika..*.multiply(int))")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) {
        return processMeasure(proceedingJoinPoint);
    }

    @Pointcut("execution(* com.zenika.bean.*.set*(..))")
    public void setMethod() {
    }

    @Pointcut("execution(* com.zenika.bean.*.toString())")
    public void toStringMethod() {
    }
}
