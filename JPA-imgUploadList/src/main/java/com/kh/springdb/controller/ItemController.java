package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Item;
import com.kh.springdb.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	//메인페이지
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items= itemService.allItemView();
		model.addAttribute("items",items);
		return "index";
	}
	//상품 전체 목록 페이지로 이동하기 위한 getmapping
	@GetMapping("/item/list")
	public String itemList(Model model) {
		List<Item> items = itemService.allItemView();
		model.addAttribute("items",items);
		return "itemList";
	}
	//상품등록 페이지로 이동하기 위한 getmapping
	@GetMapping("/item/new")
	public String itemSaveForm(Model model) {
		return "addItemForm";
	}
	
	//클라이언트가 등록한 상품 등록 내용을 디비에 로그인
	@PostMapping("/item/new")
	public String itemSave(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
		if(item.getImgPath() !=null || item.getImgName() != null) {
			itemService.saveItem(item, imgFile);
		}else {
			itemService.saveItem(item, null);
		}
			
		return "redirect:/item/list";
	}
	
	//상세보기
	@GetMapping("/item/detail/{id}")
	public String itemdetail(@PathVariable("id") int id, Model model) {
		Item item = itemService.getItemById(id);
		model.addAttribute("item",item);
		return "itemDetail";
	}
	
	
}
