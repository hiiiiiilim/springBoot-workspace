package com.kh.spring.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.spring.cafe.vo.Cafe;

public interface CafeReporsitory extends JpaRepository<Cafe, Long> {
	//count를 이용해서 지역의 갯수가 몇 개인지 찾아보는 메서드
	Long countByLocation(String location);
	
	/*@Query("select c from Cafe c where c.name like %:keyword%")
	//1.만약에 보여줄 것이 많다. => list로 담아서 한번에 보여주자
	List<Cafe> findCafe(@Param("keyword") String keyword);*/
	//2.보여줄 것이 하나 => cafe 객체 하나만 호출할 것 
	
	//특정 문자열을 포함한 엔터티를 검색하는데 사용하는 메서드
	List<Cafe> findByNameContaining(String keyword);
	
}

/*
 쿼리
 	1. JPA에서 SQL AND 구문을 서야할 때 findBy변수명AND다른변수명
 	2. JPA에서 sql or 구문을 써야할 때 findBy변수명OR다른변수명
 	3. JPA에서 sql is 또는 Equals 구문을 써야할 때
 		findBy변수명IS
 		findBy변수명Equals
 	4.  JPA에서 sql Between After Before Like 구문을 써야할 때
 		findBy변수명Between
 		findBy변수명After
 		findBy변수명Before
 		findBy변수명Like
 	5. OrderBy In False True IgnoreCase
 		findBy변수명OrderBy정렬하고자하는 기준변수 Desc/asc
	6. JPA 에서 SQL In 구문을 써야할 떄
		findBy변수명In(List<예약어> 변수명)
	7. JAP에서 SQL false true구문을 써야할 때
		findBy변수명True()
		findBy변수명False()
			sql : where 테이블명의단축어.변수명 = true
			sql : where 테이블명의단축어.변수명 = false
 		
	8. JAP에서 SQL IgnoreCase구문을 써야할 때
		findBy변수명IgnoreCase
	
 * */
