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
	//값을 반환하지 않고 넣어서 void
	void insertUser(User user);
	//유저 정보수정 메서드
	void updateUser(User user);
	//유저 정보 삭제 메서드
	void deleteUser(int mno);
	
}
