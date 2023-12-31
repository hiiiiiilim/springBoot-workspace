package com.kh.spring.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.cafe.repository.CafeReporsitory;
import com.kh.spring.cafe.vo.Cafe;

@Service
public class CafeService {
	@Autowired
	private CafeReporsitory cafeReporsitory;
	
	//전체검색
	public List<Cafe> getAllCafes(){
		return cafeReporsitory.findAll();
	}
	//부분검색
	public Optional<Cafe> getCafeById(Long id) {
		return cafeReporsitory.findById(id);
	}
	//추가하기
	public Cafe saveCafe(Cafe cafe) {
		return cafeReporsitory.save(cafe);
	}
	//삭제하기
	public void deleteCafeById(Long id) {
		cafeReporsitory.deleteById(id);
	}
	
	//부분검색
	public List<Cafe> searchCafes(String keyword){
		//return cafeReporsitory.findCafe(keyword);
		return cafeReporsitory.findByNameContaining(keyword);
	}
	
	//repository에 작성한 지역 카운터를 가져와서 이용할 수 있는 메서드를 추가
	public Long countCafeByLocation(String location) {
		return cafeReporsitory.countByLocation(location);
	}
	
	//카페가 존재하는지 존재여부
	public boolean existsCafeByName(String name) {
    	return cafeReporsitory.existsByName(name);
    }
}
