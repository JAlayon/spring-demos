package com.alayon.app.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {
	
	/**
	 * Pointcuts
	 */
	
	//Execute in all methods
	@Pointcut("execution(* *(..))")
	public void allMethods() {}
	
	//Execute in all public methods
	@Pointcut("execution(public * *(..))")
	public void allPublicMethods() {}
	
	
	//Execute all methods in the path specified
	//@Pointcut("execution(* com.alayon.app.aspect.target.*.* (..))")
	//public void allMethodsTargetPackage() {}
	
	//The same from above method
	@Pointcut("within(com.alayon.app.aspect.target.*)")
	public void allMethodsInTargetPackage() {}
	
	//All methods in package and subpackages
	@Pointcut("within(com.alayon.app.aspect.target..*)")
	public void allMethodsInPackageAndSubpackage() {}
	
	
	/**
	 * Advices
	 */
	
	@Before("allMethodsInTargetPackage()")
	public void adviceA(JoinPoint joinPoint) {
		Logger.getLogger("com.alayon.app."+joinPoint.getSignature().getName())
			.info("===Advice before execute <allMethodsTargetPackag>: ");
	}
	
	
	@Before("@within(com.alayon.app.aspect.MyClassAnnotation)")
	public void adviceB(JoinPoint joinPoint) {
		Logger.getLogger("com.alayon.app."+joinPoint.getSignature().getName())
			 .info("===Advice before execute methods with <@MyClassAnnotation>");
	}
	
	@Before("@within(com.alayon.app.aspect.MyMethodAnnotation)")
	public void adviceC(JoinPoint joinPoint) {
		Logger.getLogger("com.alayon.app."+joinPoint.getSignature().getName())
			.info("===Advice before execute methods with <@MyMethodAnnotation>");
	}
	
	
	@AfterReturning(pointcut = "allMethodsInTargetPackage()", returning = "result")
	public void adviceD(JoinPoint jp, int result) {
		Logger.getLogger("com.alayon.app."+jp.getSignature().getName())
			.info("===Advice after execute methods returning <int>: " + "\n===Return: " + result);
	}
	
	
	@AfterThrowing(pointcut = "allMethodsInTargetPackage()", throwing = "exception" )
	public void adviceE(JoinPoint jp, Exception exception) {
		Logger.getLogger("com.alayon.app."+jp.getSignature().getName())
		.info("===Advice after execute methods throwing an <Exception>: " + "\n===Return: " + exception);
	}
	
	
	@After("execution (* com.alayon.app.aspect.target.MockService.methodWithException())")
	public void adviceF(JoinPoint jp) {
		Logger.getLogger("com.alayon.app."+jp.getSignature().getName())
			.info("===Advice after execute <methodWithException> (finally)");
	}
	
	
	@Around("execution(* com.alayon.app.aspect.target.MockService.method())")
	public Object adviceG(ProceedingJoinPoint jp) throws Throwable{
		Logger.getLogger("com.alayon.app").info("=========Before........");
		Object obj = jp.proceed();
		Logger.getLogger("com.alayon.app").info("=========After........");
		return obj;
	}
	
	
}
