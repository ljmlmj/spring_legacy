package com.javalab.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalab.spring.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	// @GatMapping 어노테이션 : Spring Framework 버전 4.3에서 도입
	// requestMapping은 양쪽을 다 받는거다
	// @GetMapping은 get 만 받는다.
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// formReset 페이지 오픈
	@PostMapping("/formRest")
	public String formRest(
			@ModelAttribute("member") MemberVo member) {	//커맨드 객체MemberVo가 member라는 이름으로 꺼내 사용할수있다. 
															// MemberVo 커맨드 객체 다음화면으로 이동 -> request에 넣은거랑 마찬가지이다. 꺼내서 사용할수있음
		
		return "formRest";	// 응답 페이지 : formRest.jsp
	}
	
	/*
	 * 응답페이지 : formRest2.jsp
	 * 
	 * 응답 페이지가 생략되면 호출된 url formRest2가 반환되어
	 * formRest2.jsp 페이지를 찾아간다.
	 */
	@RequestMapping(value = "/formRest2", method = {RequestMethod.POST, RequestMethod.GET})	// 반환타입이 없는(void 인)경우 formRest2 로 반환됨, JSP페이지가 된다.
	public void formRest2(
				@ModelAttribute("name") String name) {	//@ModelAttribute 이동해 갈 페이지에서 객체를 받음 -> 화면단에서 뭔가 넘어옴  같은이름이 있으면 넣어줌 -> 이동하게되면 memberVo로 넘거가게 된다.
														// 다음화면에 (자동으로)넘기기 위해 사용, model에 담지않아도 알아서 넘겨줌
		//return "formRest2";		//생략해도 응답페이지 : formRest2.jsp를 찾아간다.
	
	}
	/*
	 * formRest.jsp에서 ajax 형태로 호출됨
	 * [@PathVariable] 형태로 값을 전달 받는 방법
	 * - 경로명?name="홍길동"&grade="3"와 같은 형태
	 * [@ResponseBody]
	 * - 호출한 곳으로 응답할때 "메시지 바디"에 담아서 전달해주면 받는 JSP페이지 Body에
	 *   그대로 전달됨. 자바스크립트에서 그걸 가공해서 사용함
	 * - <jackson-databind> 디펜던시(라이브러리)가 필요함
	 *   Jackson은 Java 애플리케이션에서 JSON 데이터를 처리하는데 널리 사용되며 JSON 데이터를 Java 객체로 변환(역직렬화)하고
	 *   Java 객체를 JSON 데이터로 변환(직렬화)하는 기능을 제공
	 *   JSON을 Java Object로 변환하는데 사용할 수 있는 Java 라이브러리
	 * - Map<String, Object> : Map 타입으로 key-value 형태를 JSON Type 문자열로 반환 
	 */
	@RequestMapping(value="/action3.do/name1/{name2}/grade1/{grade2}", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Map<String, Object> action3(@PathVariable("name2") String name,	// @PathVariable 경로로 전달된 변수 
													 @PathVariable("grade2") int grade,		// 브라우저에서 문자값으로 넘어왔지만(ajax로 넘겨줌) integer 타입으로 바꿔준다.
													 Model model){
		Map<String, Object> member = new HashMap<>();
		member.put("name", name);
		member.put("grade", grade);
		
		// 호출한 화면의 바디(body)에 JSON 타입으로 전송되고
		// success callback에서
		// 자바스크립트를 통해서 화면의 특정 부분을 살짝 변화시킴
		// @ReponseBody 어노테이션이 있어야 가능함.		-> <jackson-databind> 디펜던시(라이브러리)가 필요함
		return member;		//자바객체가 웹으로 갈 수 없다.	그래서 @ReponseBody가 필요!!!
	}//end action3
	
	/*
	 *  
	 */
	
}
