package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//유저 조회
	User findByUsername(String username);
	//아이디찾기
	User findById(int id);
}
