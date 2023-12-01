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
	public String getAllCafes(Model model, @RequestParam(required = false) String name) {
		//카페 리스트를 만들어준 후 만약에 리스트에서 카페가 존재한다면 그 카페 목록들만 보여주고
		//만약에 존재하지 않는다면 그냥 모든 카페 내용을 보여주겠다.
		List<Cafe> cafes;
		if(name != null && !name.isEmpty()) { /*/*만약에 카페이름 값이 빈 값이 아니거나 null값이 아니라면) {
				-> 사람들이 검색한 카페 내용을 service에서 가져와서 뿌린다음에
				cafes에 넣어버리겠다.*/
			cafes = cafeService.searchCafes(name);
			
		}else {/*모든 카페리스트를 보여주겠다.*/
			  cafes = cafeService.getAllCafes();
		}
		model.addAttribute("cafes", cafes);
		return "cafeList";
	}

	
	
	@GetMapping("/new")
	public String showCafeFrom(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	
	@PostMapping("/save")
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
	
//	@GetMapping("/search")
//	public String searchCafes(@RequestParam String keyword, Model model) {
//		//특정 키워들을 포함하는 카페를 검색
//		List<Cafe> cafes = cafeService.findCafes(keyword);
//		//모델의 검색결과 추가
//		model.addAttribute("cafes", cafes);
//		
//		//검색결과를 보여줄 뷰페이지 작성
//		return "searchResults";
//	}
	
	//GetMapping을 활용해서 count해준 location을 가지고 오기
	@GetMapping("/count/{location}")
	public String countCafeByLocation(@PathVariable String location, Model model) {
		Long cafeCount = cafeService.countCafeByLocation(location);
		// 1. 지역값을 저장할 모델 2. 지역 갯수를 저장해줄 모델이 필요
		model.addAttribute("location",location);
		model.addAttribute("cafeCount", cafeCount);
		return "cafeCount";
	}
}
