package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SecurityUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_user_seq")
	@SequenceGenerator(name="sec_user_seq", sequenceName = "sec_user_seq", allocationSize = 1)
	private Long id;
	@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	private String password;
}
