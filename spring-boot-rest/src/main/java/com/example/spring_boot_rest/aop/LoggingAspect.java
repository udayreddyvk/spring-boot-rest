package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.spring_boot_rest.service.JobService.getJob(..))") //return type, class name.method name(args). "*" indicates 'All'
    public void logMethodCall(JoinPoint jp ) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* com.example.spring_boot_rest.service.JobService.getJob*.*(..))") //return type, class name.method name(args). "*" indicates 'All'
    public void logMethodExecuted(JoinPoint jp ) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }
}
