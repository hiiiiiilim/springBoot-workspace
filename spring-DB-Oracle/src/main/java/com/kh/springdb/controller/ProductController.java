package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ProductController {
	@Autowired
    private com.kh.springdb.service.ProductService productService;
	
	@GetMapping("productLists")
	public String displayProductList(Model model) {
		//model에 상품을 모두 조회한 상품리스트를 추가할 것 
		//                ("변수명", 내용이 저장되어 있는 변수명)
		//model.addAttribute("products","제품 저장할 공간");
    	model.addAttribute("products",productService.getAllProducts());
		return "productLists"; //ThyemLeaf가 저장되어있는 템플릿의 이름을 작성
	}
}
