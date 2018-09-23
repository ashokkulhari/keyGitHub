package com.key.configuration;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.key.util.CommonUtils;

@Aspect
@Component
public class KeyAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
//	@Before ("execution (* com.key.service.UserServiceImpl.*(..))")
//	public void before(JoinPoint joinPoint){
//		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" Before: "+joinPoint.getSignature().getName() +" Input Args : " +Arrays.toString(joinPoint.getArgs()));
//	}
//	
//	@After ("execution (* com.key.service.UserServiceImpl.*(..))")
//	public void After(JoinPoint joinPoint){
//		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" After: "+joinPoint.getSignature().getName());
//	}
	
	@AfterReturning (pointcut="execution (* com.key.service.UserServiceImpl.*(..))",returning ="result")
	public void afterReturining(JoinPoint joinPoint,Object result){
		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" AfterReturining: "+joinPoint.getSignature().getName()+" Result : "+result);
	}
	
	@Around("execution (* com.key.service.UserServiceImpl.*(..))")
	  public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
	    // start stopwatch
		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" Before: "+pjp.getSignature().getName() +" Input Args : " +Arrays.toString(pjp.getArgs()));
		long start = System.currentTimeMillis();
        Object output = pjp.proceed();
	    // stop stopwatch
        LOGGER.debug(CommonUtils.getCurrentTimestamp()+" After: "+pjp.getSignature().getName());
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
	  }
}
