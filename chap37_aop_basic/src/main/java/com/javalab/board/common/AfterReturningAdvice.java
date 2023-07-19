package com.javalab.board.common;

import org.aspectj.lang.JoinPoint;


/**
 * AfterReturning Advice 
 *  - 타겟 메소드가 정상적으로 실행 완료된 후에 본 클래스의 메소드가 호출된다.
 *
 */
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}

	/*
	 * JoinPoint jp : 클라이언트가 호출한 타겟(비즈니스) 메소드 정보 알아내는 역할
	 * Object returnObj : 바인드 변수라고 하며 타겟 메소드가 실행되고 반환된
	 *  값을 바인딩하는 역할
	 */
	public void afterLog(JoinPoint jp, Object returnObj) {

		System.out.println("[사후 처리] 타겟 메소드 수행 후에 실행됩니다.");

		String method = jp.getSignature().getName();

		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + returnObj.toString());
	}

}
