package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//로그인을 하기 위해서 검색하는 코드를 작성해줄 예정
	Optional<User> findByUserName(String username);
}
