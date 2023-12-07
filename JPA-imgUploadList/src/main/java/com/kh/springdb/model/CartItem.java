package com.kh.springdb.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartItem_seq")
	@SequenceGenerator(name="cartItem_seq", sequenceName = "cartItem_seq", allocationSize = 1)
	private int id;
	
	//어떤 아이템인지 알기 위해 아이템클래스를 가지고 옴.
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="item_id")
	private Item item;
	
	//장바구니에 담아야하기 때문에 장바구니 클래스도 가지고 옴
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	//상품개수
	private int count;
	
	public static CartItem createCartItem(/*Cart cart, */Item item, int amount) {
		CartItem cartItem = new CartItem();
		//cartItem.setCart(cart);
		cartItem.setItem(item);
		cartItem.setCount(amount);
		return cartItem;
	}
	
	//이미 담겨잇는 물건이나 또는 담을 물건이 있을 경우 추가
	public void addCount (int count) {
		this.count+=count;
	}
}

/*카트와 카트  아이템의 차이점
 * 카트: 사용자가 담거나 주문한 상품들을 담아주는 역할. 현재는 user 연결을 해주지않아서 큰 의미는 없지만 추후 User와 연결하게되면 User-cart와 연관관계가 생길 예쩐
 * 카트아이템: 카트에 담긴 각상품의 정보를 포함. 개별 상품들을 나타냄
 * 카트 아이템이 실질적으로 장바구니역할을 함
 *  * **/
