package com.perficient.techbootcampcalvintodd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTime {

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionTime.class);

    @Around("@annotation(LogExecutionTimeInt)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.error(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}
