package com.javalab.mybatis.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.mybatis.dao.BoardDAO;
import com.javalab.mybatis.dao.UserDao;
import com.javalab.mybatis.vo.BoardVO;
import com.javalab.mybatis.vo.RoleVo;
import com.javalab.mybatis.vo.UserVo;

import lombok.extern.slf4j.Slf4j;


@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	public UserServiceImpl() {
	}
	
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	@Override
	public void insertBoard(UserVo vo) {
		dao.insertUser(vo);
	}

	// 권한 조회
	@Override
	public List<RoleVo> getRoles() {
		return dao.getRoles();		
	}

}
