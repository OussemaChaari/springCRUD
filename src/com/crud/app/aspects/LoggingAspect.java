package com.crud.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.crud.app.controllers.*.*(..))")
	private void controllersPackage() {
		
	}
	
	@Pointcut("execution(* com.crud.app.services.*.*(..))")
	private void servicesPackage() {
		
	}
	
	@Pointcut("execution(* com.crud.app.dao.*.*(..))")
	private void daoPackage() {
		
	}
	
	@Pointcut("controllersPackage() || servicesPackage() || daoPackage()")
	private void appFlow() {
		
	}
	
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		//get the name of the called method
		String method = joinPoint.getSignature().toShortString();
		logger.info("===> Method called:" + method );
		
		//get the arguments
		Object[] args = joinPoint.getArgs();
		logger.info("==> arguments of "+method + ": ");
		for (Object o : args) {
			logger.info(o);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")//Advice that runs after the successful execution of method belonging to the appflow
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("===>> in @afterReturning Method called:" + method );
		
		//data returned
		logger.info("++>> result: "+result);
	}
}











