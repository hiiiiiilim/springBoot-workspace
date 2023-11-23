package com.kh.springprojectchap1.web;

public class NewFileController {
//html jsp view 공간과 db 연결하는 역할, 파일경로를 설정할깨 항상 run 하는 java 파일 하위폴데 에다가 설정
	//만약에 하위로 보지 않고 따로 만들어서 사용할 경우에는 컴포넌트 스캔(폴더를 바라보는 위치를)을 별도로 지정해줘야함
	@GetMapping
	public String hello() {
		return "Hello, world!";
	}
}
