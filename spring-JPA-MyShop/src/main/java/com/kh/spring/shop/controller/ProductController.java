package com.kh.spring.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.shop.service.ProductService;
import com.kh.spring.shop.vo.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	// 모든 제품을 보기위한 메서드
	@GetMapping
	public String getAllProducts(Model model){
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products",products);
		//return productService.getAllProducts();
		return "product_list";
	}
	// 제품 상세보기 메서드
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_detail";
	}
	
	// save GetMapping PostMapping
	// 작성한 내용을 저장하기 위한 메서드
	@GetMapping("/new")
	public String displayProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product_form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product", value));
		return "product_form";
	}
	
	// 하나의 제품을 삭제하는 메서드
	// delete @GetMapping
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}

}
