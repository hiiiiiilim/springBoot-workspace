package com.kh.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.spring.shop.service.ShopService;

public class ShopController {
	@Autowired
	private ShopService shopService;
	
	public ShopController(ShopService shopService) {
		this.shopService=shopService;
	}
}
