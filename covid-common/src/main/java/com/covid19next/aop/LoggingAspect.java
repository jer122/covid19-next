package com.covid19next.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.covid19next.service..*(..))")
    public void startLog(JoinPoint joinPoint) {
        log.info("==============================");

        // 전달 되는 파라미터 Object를 배열로 가져온다
        log.info("1. Params -> {}", Arrays.toString(joinPoint.getArgs()));

        // 해당 Advice의 타입을 알아낸다.
        log.info("2. Advice -> {}", joinPoint.getKind());

        // 대상 객체의 메소드 정보
        log.info("3. MetHods -> {}", joinPoint.getSignature().getName());

        // Target의 객체 정보
        log.info("4. Target Object -> {}", joinPoint.getTarget().toString());

        // Advice를 행하는 객체 정보
        log.info("5. Advice Target -> {}", joinPoint.getThis().toString());
    }

    @Around("execution(* com.covid19next.service..*(..))")
    public Object timeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info(Arrays.toString(proceedingJoinPoint.getArgs()));

        //타겟이 실행하는 부분 해당 부분이 없으면 Advice 적용된 메소드 동작 안함
        Object result = proceedingJoinPoint.proceed(); // proceed는 Throwable 에서 처리해야함

        long endTime = System.currentTimeMillis();
//        long executionTime = (endTime - startTime)/1000;
        long executionTime = endTime - startTime;
        log.info("target EndTime(ms) -> {}", proceedingJoinPoint.getSignature().getName() + " : " + executionTime);
        log.info("==============================");

        return result;
    }
}
