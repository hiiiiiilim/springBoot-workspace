package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //@NotNull로 표시된 필드를 사용해서 생성자를 생성
public class ItemController {
	private final ItemService itemService;
	
	//@GetMapping 상품등록 페이지 //admin만 등록할 수 있게 수정
	@GetMapping("/new")
	public String addItemForm() {
		return "나중에 작성해줄 템플릿.html";
	}
	
	//@PostMapping 상품등록으로 입력된 값을 DB에 보내기 //admin만 등록할 수 있게 수정
	@PostMapping("/save")
	public String saveItem(Item item, MultipartFile photoFile) {
		//MultipartFile을 이용해서 상품을 등록할 때 이미지 파일도 같이 등록될 수 있도록 파라미터 생성
		//itemService.addItem(item); //이미지 없이 상품을 등록하고 싶다면 아이템만 작성해도되지만 이미지 또한 포함해서 상품을 등록하고 싶다면 item, photoFile을 추가해서 작성
		itemService.addItem(item, photoFile);
		return "redirect:/itemList";
	}
	
	//상세
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("item",itemService.getItemById(id));
		return "viewItem";
	}
	
	//수정
	//삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		itemService.itemDelete(id);
		return "itemList";
	}
}
