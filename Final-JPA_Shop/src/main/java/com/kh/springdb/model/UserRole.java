package com.kh.springdb.model;

import lombok.Getter;

/*
 enum : final 상수 집합을 나타낼 때 사용하는 값
 변수 : 변할 수 있는 수
  상수 : 언제나 한결 같은 수 
 public static final
 private static final
 * */
@Getter
public enum UserRole { 
	//admin
	//나열해야하는 상수들은,를 사용해서 나열하고 나열을 종료할때는 최종적으로 ;를 사용한다.
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	//현재 유저가 admin인지 user인지 로그인하기 전까지 파악되지 않기때문에 value라는 값을 로 추후에 로그인할 경우 value에다가 admin 또는 user를 넣어줌
	private String value;
	//어떤 유저인지 값을 받아오기 위해 value를추가
	UserRole(String value){
		this.value=value;
	}
}
