package com.javalab.board.common;

/*
 * 어드바이스 
 *  - 공통로직으로 메소드 호출 때마다 그 전에 이 클래스의
 *    printLog()메소드를 호출해서 로그를 남기도록 한다.
 */
public class LogAdvice {

	public LogAdvice() {
	}

	public void printLog(){
		System.out.println("[로그기록] 비지니스 로직 수행전 로그를 남깁니다.");
	}	

}
