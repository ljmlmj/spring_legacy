package com.javalab.board.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*
 * BeforeAdvice를 어노테이션 방식으로 적용
 * @Service 어노테이션	-> 빈으로 생성 ->부모컨테이너로 올림
 *  - 본 어드바이스가 스프링 컨테이너에 의해서 적용되기 위해서는
 *    root-context.xml에 빈등록 되어 있거나 객체로 생성되어
 *    있어야한다. 그래서 @Service 붙어 있어야 한다.
 * @Aspect : XML에 설정했던 애스펙트를 어노테이션 방식으로 적용하겠다는 의미
 */

@Service
@Aspect
public class AfterAdvice {
	
	public AfterAdvice() {
		System.out.println("AfterAdvice 어드바이스 객체 생성됨");
	}//end AfterAdvice() 생성자
	
	/*
	 * XML에 설정했던 포인트컷을 어노테이션 방식으로 적용
	 *  - allPointCut 메소드 : 별다른 역할은 없고 단지 포인트컷 한정식을 위한 용도임
	 *  - getPointCut 메소드 : 별다른 역할은 없고 단지 포인트컷 한정식을 위한 용도임
	 */
	
	@Pointcut("execution(* com.javalab.board..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.javalab.board..*Impl.get*(..))")
	public void getPointCut() {}
	
	/*
	 * 애스팩트 역할 메소드
	 * 
	 */
	@After("allPointCut()")
	public void finallyLog() {
		
		System.out.println("[어노테이션 방식의 AfterAdivce] 타겟 메소드 실행 후에 수행됩니다.");
	} //	public void finallyLog() 
	
}//end class BeforeAdvice