package com.kh.spring.cafe.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.cafe.service.CafeService;
import com.kh.spring.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafes")
public class CafeController {
	private final CafeService cafeService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService=cafeService;
	}
	
	@GetMapping
	public String getAllCafes(Model model) {
		model.addAttribute("cafes",cafeService.getAllCafes());
		return "cafeList";
	}
	
	@GetMapping("/new")
	public String showCafeFrom(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	
	@PostMapping
	public String saveCafe(@ModelAttribute Cafe cafe) {
		cafeService.saveCafe(cafe);
		return "redirect:/cafes";
	}
	
	@GetMapping("/update/{cafeId}")
	public String updateCafe(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafe",value));
		return "cafeForm";
	}
	
	@GetMapping("/delete/{cafeId}")
	public String deleteCafe(@PathVariable Long cafeId) {
		cafeService.deleteCafeById(cafeId);
		return "redirect:/cafes";
	}
	
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		//특정 키워들을 포함하는 카페를 검색
		List<Cafe> cafes = cafeService.findCafes(keyword);
		//모델의 검색결과 추가
		model.addAttribute("cafes", cafes);
		
		//검색결과를 보여줄 뷰페이지 작성
		return "searchResults";
	}
}
