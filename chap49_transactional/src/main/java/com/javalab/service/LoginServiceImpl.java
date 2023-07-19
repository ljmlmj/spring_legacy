package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.LoginDAO;
import com.javalab.vo.User;

import lombok.extern.slf4j.Slf4j;

@Service("loginService")
@Slf4j
public class LoginServiceImpl implements LoginService  {
	
	private static final Logger log = 
					LoggerFactory.getLogger(LoginServiceImpl.class);
	
	//@Resource(name = "loginDao")
	@Autowired
	private LoginDAO dao;

	public LoginServiceImpl() {
	}

	public User getUserById(User vo) {
		log.info(vo.toString());
		return dao.getUserById(vo);
	}

}
