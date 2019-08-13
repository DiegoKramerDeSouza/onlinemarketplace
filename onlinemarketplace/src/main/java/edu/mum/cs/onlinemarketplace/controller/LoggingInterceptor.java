package edu.mum.cs.onlinemarketplace.controller;

import ch.qos.logback.core.CoreConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class LoggingInterceptor {

    @Pointcut("@annotation(LoggingAnnotation)")
    public void annotation() {
    }

    @Before("annotation()")
    public void log(JoinPoint p) {
        System.out.println(p.getSignature().toShortString());

    }
}
