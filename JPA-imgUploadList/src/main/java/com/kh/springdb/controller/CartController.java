package com.kh.springdb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.Item;
import com.kh.springdb.service.CartService;
import com.kh.springdb.service.ItemService;

@Controller
@RequestMapping("cart")
public class CartController {
	private final CartService cartService;
	private final ItemService itemService;

	public CartController(CartService cartService, ItemService itemService) {
		this.cartService=cartService;
		this.itemService=itemService;
	}
	
	//장바구니 목록 보여주기 위한 
	@GetMapping
	public String viewCart(Model model) {
		Cart cart =cartService.getCartById(1L);
		model.addAttribute("cart",cart);
		return "cartView";
	}
	
	//주소를 접속하기 위해서
	/**
	 * @param itemId
	 * @param model
	 * @return
	 */
	@GetMapping("/add/{itemid}")
	public String addToCart(@PathVariable int itemId, Model model){
		//장바구니에 상품추가
		Item newItem = itemService.getItemById(itemId);
		//@PathVariable Long itemId 만약에 파라메터값이 Long일경우에는 longValue()작성을 해주고
		//.intValue() Integer 쓴 객체를 int로 변환하는 메서드
		//Item newItem = itemService.getItemById(itemId.intValue());
		//Integer와 int의 차이
		//Integer - Wrapper 클래스 객체로 감싸져 있기 때문에 null값을 가질 수 잇음
		//	int - java에서 기본 데이터 타입 정수를 나타내는 값임 null값을가질 수 없음.
		
		//임의의 값을 지정해줄때 1L이라는 표현을 쓰기도 함
		cartService.addCart(4L, newItem, 1);
		return "redirect:/cart";
		//1L이란?
		
	}
}
