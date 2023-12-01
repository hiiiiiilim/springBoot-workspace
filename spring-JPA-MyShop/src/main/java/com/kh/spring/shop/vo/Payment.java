package com.kh.spring.shop.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payment")
@Getter
@Setter
public class Payment {
	//데이터베이스에 주문정보를 저장하기 위한 클래스
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentId_Seq")
	@SequenceGenerator(name="paymentId_Seq", sequenceName="paymentId_Seq", allocationSize=1)
	private Long id;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Product order;
	private String paymentStatus;
}

/*
 	@joinColumn(name = "조인하고자하는 컬럼명") 외래키(FOREIGN KEY)
 	데이터베이스의 테이블로 존재하는 객체를 작성
 	
 	private int quantity; = 해당 제품의 수량을 표현
 	@ManyToOne(N:1)관계를 설정하는 어노테이션
 	주문이 하나의 제품에 속하는 경우 product_id 값이 중복으로 들어갈 수 있음을 나타내기 위해N:1
 * */
