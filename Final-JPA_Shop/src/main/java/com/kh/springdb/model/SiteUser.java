package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;

@Getter
@Setter
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name="user_seq", sequenceName = "user_seq", allocationSize = 1)
	private Long id;
	//isRole 가입할때 마다 이사람이 판매자인지 구매자인지
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	//private int isRole;
	
	@Column(unique = true)
	private String username;
	private String password;
	@Column(unique = true)
	private String email;
	//추천인을 넣고싶다면 추천자를 생성해서 넣어도됨
}
