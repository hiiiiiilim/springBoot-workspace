package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//구매자가 주문한 내역을 볼 수 있는 객체 생성
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name="order_seq", sequenceName = "order_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user; //구매자 유저
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	//구매 날짜 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate=LocalDate.now();
	}
	
	//아이템 추가 생성자 
	public void addOrderItem(OrderItem orderItem) {
		//상품리스트에 추가
		orderItems.add(orderItem);
		//setOrder에 저장
		orderItem.setOrder(this);
	}
	//새로운 주문 생성자
	
}
