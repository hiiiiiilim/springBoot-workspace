package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.User;

@Mapper
public interface UserMapper {
	//모든 유저 조회
	List<User> getAllUsers();
	//한 유저 조회
	User getUserById(int id);
}
