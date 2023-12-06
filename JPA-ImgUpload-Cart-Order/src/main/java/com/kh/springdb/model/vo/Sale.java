package com.kh.springdb.model.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sal_seq")
	@SequenceGenerator(name="sal_seq", sequenceName = "sal_seq", allocationSize = 1)
	private int id;
	
	//판매자
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="saller_id")
	private User seller;
	
	@OneToMany(mappedBy="sale")
	private List<SaleItem> saleItem = new ArrayList<>();
	
	//총 판매 갯수
	private int totalCount;
	
	//판매정보를 새로 생성하는 메서드
	public static Sale createSale(User seller) {
		Sale sale = new Sale();
		sale.setSeller(seller);
		sale.setTotalCount(0);
		return sale;
	}
}

/*
 Sale과 SaleItem
 Sale -> 판매정보를 나타내는 객체판매자와 총 판매 개수와 같은 속성을 가짐
 SaleItem : 판매정보에 속해있는 각 상품에 대한 정보를 나타냄
 */
