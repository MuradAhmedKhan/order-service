package com.murad.order_service.application.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.murad.order_service.application.services..*(..))")
    public void serviceMethodPointcut(){}

    @Around("serviceMethodPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String method = joinPoint.getSignature().toShortString();

        try {
            
            log.info("Received request for {} with args: {}", method, Arrays.toString(joinPoint.getArgs()));
            
            Object result = joinPoint.proceed();

            log.info("Exiting {} with result: {}", method, result);

            return result;

        } catch (Throwable throwable) {
            log.error("Error in {}", method, throwable);
            throw throwable;
        } 
        finally{
            stopWatch.stop();
            log.info("Execution time for {}: {} ms", method, stopWatch.getTotalTimeMillis());
        }
    }
}