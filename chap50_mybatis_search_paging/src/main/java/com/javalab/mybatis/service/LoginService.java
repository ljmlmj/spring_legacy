package com.javalab.mybatis.service;

import com.javalab.mybatis.vo.UserVo;

public interface LoginService {
	UserVo getUserById(UserVo vo);
}