package com.selendemir.finalproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class RunningTimeAspect {

    Logger logger = Logger.getLogger(RunningTimeAspect.class.getName());

    @Around("@annotation(runningTime)")
    public Object run(ProceedingJoinPoint joinPoint, RunningTime runningTime) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = joinPoint.proceed();
        stopWatch.stop();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.log(Level.INFO, String.format("Class name: %s, method name: %s, execution time: %d ms",className,methodName,stopWatch.getTotalTimeMillis()));
        return proceed;
    }

}