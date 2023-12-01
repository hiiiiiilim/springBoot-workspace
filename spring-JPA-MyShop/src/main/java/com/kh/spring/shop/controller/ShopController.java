package com.kh.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kh.spring.shop.service.ShopService;
import com.kh.spring.shop.vo.Product;
//주문과 결제
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	public ShopController(ShopService shopService) {
		this.shopService=shopService;
	}
	
	//주문에 관련된 내용을 처리하는 메서드
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody Product prodcut, int quantity, Model model) {
		//주문을 처리하고 주문한 결과를 order에 반환하겠다.
		shopService.placeOrder(prodcut, quantity);
		//여기서 model에 필요한 데이터를 추가
		model.addAttribute("msg","주문이 성공적으로 전달되었습니다.");
		return "redirect:/orderCheck";
	}
	
	@PostMapping("/paymentFinish")
	public String processPayment(Long orderId, String paymentStatus, Model model) {
		//주문에 대한 결제를 처리하고 payment를 반환
		shopService.savePayment(orderId, paymentStatus);
		model.addAttribute("msg", "결제가 성공적으로 처리 되었습니다.");
		
		return "redirect:/paymentCheck";
	}
}

/*
 @RequestBody : 정보를 url이 아닌 java 객체로 받음
 				요청했던 body에 위치하도록 할 때 사용하는 것
 @RequestParam : 정보를 url에 저장
 * */

