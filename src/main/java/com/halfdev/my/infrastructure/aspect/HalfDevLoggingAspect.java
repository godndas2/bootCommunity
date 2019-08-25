package com.halfdev.my.infrastructure.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class HalfDevLoggingAspect {

	@Before(value = "@annotation(halfDevLogging)", argNames = "joinPoint, halfDevLogging")
	public void preLogging(JoinPoint joinPoint, HalfDevLogging halfDevLogging) {
		log.info("Before jointPoint : {}, type : {}", joinPoint, halfDevLogging.type());
	}

	@After(value = "@annotation(halfDevLogging)", argNames = "halfDevLogging")
	public void sufLogging(HalfDevLogging halfDevLogging) {
		log.info("After type : {}", halfDevLogging.type());
	}
}
