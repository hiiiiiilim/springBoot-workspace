package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Item {
	//id name text price count stock isSoldOut
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@SequenceGenerator(name="item_seq", sequenceName = "item_seq", allocationSize = 1)
	private int id;
	//물건이름
	private String name;
	//물건에 대한 설명
	private String text;
	// 물건에 대한 가격
	private String price;
	//판매개수
	private int count;
	//재고
	private int stock;
	//상품 품절 유무
	private int isSoldout;
	/*
	 *private boolean isCheckout; //true->판매중, false품절
		private int isSoldout //상품 상태(0:판매중/1:품절/2:일시중지 /3:10개씩 묶음판매) 
	 * */
	//이미지 업로드를 위한 파일 명, 이미지 경로, 상품등록 날짜
	@Nullable
	private String imgName;
	@Nullable
	private String imgPath;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	//DB에 값을 넣을 때 자동으로 생성된 날짜가 들어감
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
	//판매자가 누구인지, 장바구니에 어떤 아이템이 들어가 있는지 작성 x
}
