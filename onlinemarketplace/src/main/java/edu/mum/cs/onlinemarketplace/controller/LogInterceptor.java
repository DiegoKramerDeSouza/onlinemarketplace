package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Log;
import edu.mum.cs.onlinemarketplace.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogInterceptor {
    @Autowired
    LogService logService;

    @Pointcut("@annotation(edu.mum.cs.onlinemarketplace.controller.LogAnnotation)")
    public void annotation() {
    }

    @Before("annotation()")
    public void log(JoinPoint joinPoint) {
        System.out.println(LocalDateTime.now().toString() + "  :   " + joinPoint.getSignature().toShortString());
        Log log = new Log();
        log.setDateTime(joinPoint.getSignature().toShortString());
        log.setAction(LocalDateTime.now().toString());
        logService.saveLog(log);
    }
}
