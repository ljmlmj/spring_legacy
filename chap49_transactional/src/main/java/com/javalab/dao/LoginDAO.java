package com.javalab.dao;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.User;

@Mapper
public interface LoginDAO {
	
	public User getUserById(User user); 
}
