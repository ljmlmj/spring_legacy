package com.javalab.board.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public BeforeAdvice() {
		System.out.println("BeforeAdvice 어드바이스 객체 생성됨.");
	}

	public void beforeLog(){
		System.out.println("[BeforeAdvice] 핵심 메소드 실행전에 로그를 남깁니다.");
	}
	
 	/*
	public void beforeLogJp(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[BeforeAdvice - 사전 처리] " + method + "() 메소드 Args 정보 : " + args[0].toString());
	}	
	*/
}
