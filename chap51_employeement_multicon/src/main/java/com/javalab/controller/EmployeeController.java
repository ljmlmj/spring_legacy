package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.service.BoardService;
import com.javalab.service.EmployeeService;
import com.javalab.vo.BoardVO;
import com.javalab.vo.Criteria;
import com.javalab.vo.Department;
import com.javalab.vo.Employee;
import com.javalab.vo.EmployeeCommonDto;
import com.javalab.vo.Job;
import com.javalab.vo.PageDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp")	// 컨트롤러 차원의 RequestMapping
@Slf4j
@AllArgsConstructor
public class EmployeeController {

	/*
	 * [생성자를 통한 의존성 주입 방법 #1]
	 * 1. @AllArgsConstructor + private BoardService boardService;
	 */
	private EmployeeService empService;

	// 사원 목록 조회
	@GetMapping("/list.do")
	public String getemployeeList(EmployeeCommonDto eDto, 
								@ModelAttribute("cri") Criteria cri,
								Model model){
		log.info("getemployeeList 메소드 Employee : " + eDto.toString());
		
		
		List<EmployeeCommonDto> empList = empService.getEmployeeList(cri);
		model.addAttribute("empList", empList);
		  
		  
		int total = empService.getTotalEmployees(cri); 
		PageDto dto = new PageDto(cri, total);
		  
		log.info("dto : " + dto.toString()); 
		model.addAttribute("pageMaker", dto);
				  	
				
		return "/emp/empList";	// 사원 목록 jsp 페이지
	}
	
	// 한 사원 정보 조회 메소드
	@GetMapping("/read.do")
	public String getBoardById(@RequestParam("employeeId") int employeeId, 
								@ModelAttribute("cri") Criteria cri, 
		 						Model model){
		// 사원 정보 조회
		EmployeeCommonDto employee = empService.getEmployee(employeeId);	
		model.addAttribute("employee", employee);
		
		return "/emp/empView";	
	}	

	// 사원 등록폼
	@GetMapping("/register.do")
	public String registerForm(Model model){
		
		// 사원등록 폼에 기본적으로 세팅할 값 저장용 Map
		Map<String, Object> empMap = new HashMap<>();

		// 오늘 날짜 정보
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String hireDate = format1.format(today);
		
		// 부서 정보 조회
		List<Department> getDepartmentList = empService.getDepartmentList();

		// 직업 목록 조회
		List<Job> getJobList = empService.getJobList();

		// 오늘 날짜와 부서 목록 정보를 Map 객체에 담아서 모델에 저장
		empMap.put("hireDate", hireDate);
		empMap.put("departmentList", getDepartmentList);
		empMap.put("jobList", getJobList);
		
		model.addAttribute("empMap", empMap);
		
		return "/emp/empForm";	
	}	
	

	// 사원 등록 처리
	@PostMapping("/register.do")
	public String register(Employee emp, 
							Model model,
							RedirectAttributes rttr) throws IOException{  // 수정
		log.info("Employee.toString() " + emp.toString());
		
		
		// 게시물 등록(저장)
		empService.register(emp);
		
		// 저장후 목록 출력 컨트롤러 호출, redirect하면 사용자 화면의 주소창이 변경됨.
		return "redirect:/emp/list.do"; 
	}	
	
}
