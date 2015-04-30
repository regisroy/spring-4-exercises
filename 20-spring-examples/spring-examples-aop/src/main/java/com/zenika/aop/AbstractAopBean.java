package com.zenika.aop;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AbstractAopBean {
    protected StringBuilder records;

    public AbstractAopBean(StringBuilder records) {
        this.records = records;
    }

    protected void processLog(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("@Aspect: arg = " + String.valueOf(arg));
        }

        Object target = joinPoint.getTarget();
        System.out.println("@Aspect: target = " + String.valueOf(target));

        Object signature = joinPoint.getSignature();

        String labelSignature = "@Aspect: signature = " + String.valueOf(signature);
        System.out.println(labelSignature);
        records.append(labelSignature).append("\n");
    }

    protected Object processMeasure(ProceedingJoinPoint proceedingJoinPoint) {
        Monitor monitor = MonitorFactory.start("test");
        records.append("@Around Begin monitoring\n");
        Object result = null;
        try {
            records.append(" before proceed\n");
            result = proceedingJoinPoint.proceed();
            records.append(" after proceed:\n");
            records.append("  result=").append(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            monitor.stop();
            records.append("@Around End");

            System.out.printf("'Around' advice implementation - " + monitor);
        }
        return result;
    }
}
