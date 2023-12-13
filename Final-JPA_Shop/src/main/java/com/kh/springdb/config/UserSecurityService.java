package com.kh.springdb.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.User;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/*
 데이터베이스나 외부에서 로그인하여 인증을하기 위해서는 인증처리를 해야됨
 
 시큐리티 안에는 userDetailsService가 있음, 사용자 정보를 인증
  */
@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService{
	private final UserRepository userRepository;
	
	//유저에 대한정보를 로그인할 때 userDetails를 사용해서 로그인할 수있는 유저가 있는지 확인할 것
	//사용자 명을 기준으로 사용자 정보를 가져오게 할 것
	
	public UserDetails loadUserByUserName(String username) {
		Optional<User> _siteUser = userRepository.findByUserName(username);
		if(_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		User user = _siteUser.get();
		List<GrantedAuthority> autorities = new ArrayList<>();
	}
}
//UserDetails: 스프링 시큐리티가 사용자의 인증과 권한 부여를 처리하는데 필요한 정보를 제공
//인터페이스로 다양한 종류의 메서드가 있음
/*
 UserDetails 메서드
 getAuthorities():사용자가 가지고 있는 권한 목록을 반환, 권한은 GrantedAuthority갖고옴 정의된 권한에 따라 달라짐. 권한은 개발자가 설정
 getPassword(): 사용자의 비밀번호를 반환, 데이터베이스에서 암호화 처리된형태로 저장되있음
 getUsername(): 사용자명을 반환
 isEnables():계정이 활성화 되어있는지 여부를 boolean값으로 나타냄
 * */
 */