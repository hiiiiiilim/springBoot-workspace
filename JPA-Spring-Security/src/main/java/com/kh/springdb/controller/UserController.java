package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCheckForm;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	//회원가입할 때 들어갈 창 조회
	@GetMapping("/signUp")
	public String signUp(UserCheckForm userCheckForm) {
		return "signup_form";
	}
	
	//회원가입을 진행할 때 값이 존재하는지, 원하는 조건에 맞는지 확인 후 전달
	@PostMapping("/signUp")
	public String signUp(@Valid UserCheckForm userCheckForm, BindingResult bindingResult) {
		//1. 비밀번호와 비밀번호 확인이 일치하지 않을때
		//bindingResult.rejectValue(a,b,c)
		//a = 검증을 실패한 필드의 이름을 나타냄, 밑에서는 password2가 검증에 실패했음을 의미함
		//b = 검증에 실패할 경우 보여질 메세지를 담은 변수
		//c = b가 담고있는, 비밀번호가 일치하지 않는 에러났을 경우 보여질 메세지
		if(!userCheckForm.getPassword1().equals(userCheckForm.getPassword2())) {
			bindingResult.rejectValue("password2","passwordCorrect" ,"비밀번호와 비밀번호 확인이 일치하지않습니다.");
			return "signup_form"; 
		}
		//모든 내용을 잘 작성했다면 데이터베이스에 저장해주기
		userService.create(userCheckForm.getUsername(), userCheckForm.getEmail(), userCheckForm.getPassword1());
		
		//회원가입이 완료되었을경우 메인페이지로 이동
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
	
}
