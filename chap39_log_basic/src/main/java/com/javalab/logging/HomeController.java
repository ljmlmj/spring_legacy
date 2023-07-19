package com.javalab.logging;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 스프링 프로젝트 생성시 pom.xml에 의미 의존성이 들어와 있음
 * 의존성 : slf4j-api
 *  - 여기에 가보면 org.slf4j 패키지에 Logger 인터페이스가 있음
 *  - 여기에 LoggerFactory 클래스도 있음
 */
@Controller
public class HomeController {
	
	//멤버변수
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 앱실행시 최초로 요청되는 "/" 요청을 처리하는 메소드
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//1. System.out.println() 대신에 Logger.info() 사용
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//2. System.out.println() 대신에 Logger.info()  사용
		logger.info("info formattedDate "+ formattedDate);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
