package com.key.configuration;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	public void userServiceAfterReturining(JoinPoint joinPoint,Object result){
		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" AfterReturining: "+joinPoint.getSignature().getName()+" Result : "+result);
	}
	
	@Around("execution (* com.key.service.UserServiceImpl.*(..))")
	  public Object userServiceProfiling(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.debug(CommonUtils.getCurrentTimestamp()+" Before: "+pjp.getSignature().getName() +" Input Args : " +Arrays.toString(pjp.getArgs()));
		long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        LOGGER.debug(CommonUtils.getCurrentTimestamp()+" After: "+pjp.getSignature().getName());
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.debug("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
	  }
	
	
	 @AfterThrowing (pointcut = "execution(* com.key.service.UserServiceImpl.*(..))", throwing = "ex")
	 public void userServiceAfterThrowing(JoinPoint joinPoint, Throwable e) {
		    Signature signature = joinPoint.getSignature();
		    String methodName = signature.getName();
		    String stuff = signature.toString();
		    String arguments = Arrays.toString(joinPoint.getArgs());
		    LOGGER.debug("Caught exception in method: "
		        + methodName + " with arguments "
		        + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
		        + e.getMessage(), e);
		  }
	 
}
