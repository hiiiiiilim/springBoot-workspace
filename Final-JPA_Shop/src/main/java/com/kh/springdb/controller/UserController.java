package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.model.UserRole;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
//공통으로 들어가는 url이 있다면 RequestMapping 사용해서 user로 묶어주기
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	//회원가입 창
    @GetMapping("/signup")
    public String signUp(UserCreateForm userCreateForm) {
        return "signup_form";
    }
    
	//회원가입에 대한 postMapping
	@PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

		//만약 패스워드 두개가 일치하지 않는다면 일치하지 않습니다!
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
		
	    //html폼에서 선택한 역할을 가지고 오기 위해
	     UserRole role = userCreateForm.getIsRole();
	     userService.createUser(userCreateForm.getUsername(),userCreateForm.getEmail(), userCreateForm.getPassword1(),userCreateForm.getIsRole());
		//userService.createUser(userCreateForm.getUsername(), 
          //      userCreateForm.getEmail(), userCreateForm.getPassword1());
	    
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
}