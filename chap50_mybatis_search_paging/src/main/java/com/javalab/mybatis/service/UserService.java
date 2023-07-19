package com.javalab.mybatis.service;

import java.util.List;

import com.javalab.mybatis.vo.RoleVo;
import com.javalab.mybatis.vo.UserVo;

public interface UserService {	
	public int idCheck(String id);
	public void insertBoard(UserVo vo);	
	public List<RoleVo> getRoles();
}
