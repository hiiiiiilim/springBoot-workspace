package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	//로그인을 위한 옵션활용 레포생성
	Optional<SecurityUser> findByUsername(String username);

}
