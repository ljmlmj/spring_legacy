package com.javalab.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalab.spring.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	//private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("HomeController home() 메소드!");
		
		return "home";
	}
	
	/*
	 * 요청 처리후 처리 결과를 저장하고 문자열로 jsp페이지명을 반환
	 * 스프링에서 기본으로 제공해주는 model에 값을 저장하여 JSP에 전달,
	 * request 기본 객체를 사용할 수도 있지만 스프링에서는 model 사용
	 * MemberVo : 커맨드 객체 - jsp 화면에서 여러개로 넘어오는 파라미터를 
	 *            통째로 한꺼번에 바인딩 할 수 있는 객체 다음 화면으로 자동으로 넘어감
	 */
	@RequestMapping(value = "action", method = {RequestMethod.POST})
	public String action(Model model, 
						HttpServletRequest request,
						//@RequestParam("name") 과 home.jsp에 <input type="text" id="name" name="name"> name="name"이 같아야 한다.
						@RequestParam("name") String name,		
						@RequestParam Map<String, String> map,
						@RequestBody String str, 
						// @ModelAttribute MemberVo member) // 이름("member")을 바꾸지 않고 그냥 사용하기도 한다.
						//MemberVo member)					// 이렇게 사용
						@ModelAttribute("member")MemberVo member) // 이름을 변경하기 위해서 사용 
								throws UnsupportedEncodingException {
				
		log.info("HomeController action() 메소드!");
		// 1. @RequestParam("name") String name
		String strName = name;
		log.info("1. strName : "+ strName);
		
		// 2. @RequestParam Map<String, String> map
		// 선언해 놓으면 name ="값" 형태로 map으로 넣어줌
		Map<String, String> map2 = map;
		String mapName  = map2.get("name");
		log.info("2. mapName : "+ mapName);
		
		// 3. @RequestBody String str 선언해 놓으면
		// name=abc1234 형태로 넣어줌
		String bodyStr = str.split("=")[1];	// "="로 잘라서 뒷부분
		log.info("3. bodyStr : " + bodyStr);
		
		// 4. MemberVo member 형태로 선언해 놓으면
		// 자바빈처럼 memberVo 객체 생성해서 그 안에 파라미터값을 넣어줌
		// MemberVo를 커맨드 객체라고 부름
		log.info("4. member : " + member.toString());
		
		model.addAttribute("param1", name);		// model에 저장
		request.setAttribute("param2", name);	// request에 저장
		model.addAttribute("param3",mapName);	// map에 저장
		model.addAttribute("param4", bodyStr);	
		//model.addAttribute("param5", member.getName());
		model.addAttribute("param5", member);
		
		// 처리 결과를 보여줄 jsp 페이지 이름 반환
		// 리턴타입(반환형)이 void 이고 return 값이 없으면 요청한 RequestMapping
		// 문자열(value)과 같은 jsp 페이지에게 화면을 요청한다.
		return "action";	//처리 결과를 보여줄 jsp 페이지 이름 반환, 정확한 위치를 만들어주는 기능 ViewResolver // controller가 viewResolver에 접근
		// 다른방법 다른 메소드 URL이 올수도 있다. SendRedirect
	}
	/*
	 *  ModelAndView 객체에 jsp(View)페이지와 전달할 값을 담아서 반환
	 *   - 보여줄 화면 이름과 보여줄 데이터를 함께 저장하고 있는 객체임
	 */
	@RequestMapping(value="action2", method = RequestMethod.POST)
	public ModelAndView action2(
						@RequestParam("name") String name) {
		log.info("ModelAndView action");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("action2");	// 화면명(jsp)
		modelAndView.addObject("param1",name);	// 전달할 값
		
		return modelAndView;
	}
		
}//end class HomeController
