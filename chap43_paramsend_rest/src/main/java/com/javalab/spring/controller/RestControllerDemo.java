package com.javalab.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javalab.spring.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

/**
 * [Rest 컨트롤러]
 *  - 모든 메소드가 Ajax 호출에 대한 요청 처리 메소드인 경우
 *  - @Responsbody가 없어도 자동으로 반환 데이터에 붙어서 요청 화면의 바디에 써줌
 *  - @RestController = @Controller + @Responsbody
 */
@RestController	//@Controller + @ResponseBody 결함된 컨트롤러
@Slf4j
public class RestControllerDemo {
	
	/*
	 *  @RestController의 모든 메소드는 @ResponseBody가 자동으로 붙음(보이지않지만)
	 *  @ResponseBody : 요청한 페이지의 바디에 출력
	 */
	//@ResponseBody // 생략해도 자동으로 붙기 때문에 주석처리 	@RestController때문에 ResponseBody를 자동으로 모든 메소드마다 만들어준다.(보이지는 않음)
	@RequestMapping(value = "/restAction1.do/{name}/{grade}", method = {RequestMethod.POST, RequestMethod.GET})
	public MemberVo action4(
					@PathVariable("name") String name,
					@PathVariable("grade") int grade,
					Model model) {
		log.info("@RestController PathVariable");
		log.info("name : "+ name);
		log.info("grade : "+ grade);
		
		// 화면에서 전달 받은 값으로 새로운 객체를 생성해서 그대로
		// 화면에서 다시 전송
		MemberVo member = new MemberVo();
		member.setName(name);
		member.setGrade(grade);
		
		return member;	//JSON Type 문자열로 변환 (@ResponseBody + Jackson-databind이 변환 시켜줌)
	}
	
	/*
	 * @RestController의 모든 메소드 @ResponseBody가 자동으로 붙음
	 *  - @ResponseBody : 요청한 페이지의 바디에 출력
	 *  - @RequestBody memberVo : JSP 에서 ajax 형태로 요청한 값들을 커맨드 객체 자동으로 바인딩
	 */
	@RequestMapping(value = "/restAction2.do",
					method = {RequestMethod.GET, RequestMethod.POST})
	public MemberVo action5(@RequestBody MemberVo memberVo, Model model) {	//@RequestBody 자바스크립트 객체를 문자열로 받은 것을 커맨드 객체(MemberVo)로 받을수있음
		
		log.info("@restAction2.do @RequestBody action");
		log.info("name : "+ memberVo.getName());
		log.info("grade : "+ memberVo.getGrade());
		
		MemberVo member = new MemberVo();
		member.setName(memberVo.getName());
		member.setGrade(memberVo.getGrade());
		
		return member;
	}
}
