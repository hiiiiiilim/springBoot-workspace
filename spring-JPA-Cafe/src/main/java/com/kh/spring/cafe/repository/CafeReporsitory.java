package com.kh.spring.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.spring.cafe.vo.Cafe;

public interface CafeReporsitory extends JpaRepository<Cafe, Long> {
	@Query("select c from Cafe c where c.name like %:keyword%")
	
	//1.만약에 보여줄 것이 많다. => list로 담아서 한번에 보여주자
	List<Cafe> findCafe(@Param("keyword") String keyword);
	//2.보여줄 것이 하나 => cafe 객체 하나만 호출할 것 
	
}
