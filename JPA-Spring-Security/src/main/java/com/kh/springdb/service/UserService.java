package com.kh.springdb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.SecurityUser;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	//회원가입을 할경우 비밀번호를 암호화 해서 데이터베이스에 저장할 수있도록 구현
	public SecurityUser create(String username, String email, String password) {
		SecurityUser user = new SecurityUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		//passwordEncoder 사용해서 입력받은 비밀번호를 암호화 처리해서 입력
		
		this.userRepository.save(user);
		
		return user;
	}
}
