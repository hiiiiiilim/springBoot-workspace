package com.kh.springdb.model;

import jakarta.validation.constraints.*;
import lombok.*;

//사용자 아이디나 비밀번호 이메일을 회원가입할 때 필수로 넣어줬는지 확인
@Getter
@Setter
public class UserCreateForm {
	@Size(min=2, max=25)
	@NotEmpty(message = "사용자 아이디는 필수로 기입합니다.")
	private String username;
	@NotEmpty(message = "비밀번호는 필수로 기입합니다.")
	private String password1;
	@NotEmpty(message = "비밀번호는 확인은 필수로 기입합니다.")
	private String password2;
	@NotEmpty(message = "이메일은 필수로 기입합니다.")
	@Email
	private String email;
}
