package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.springdb.repository.CartItemRepository;
import com.kh.springdb.repository.CartRepository;
import com.kh.springdb.repository.ItemRepository;
import com.kh.springdb.repository.OrderRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.CartItem;
import com.kh.springdb.model.Item;
import com.kh.springdb.model.Order;
@Service
//@RequiredArgsConstructor
public class CartService {
    @Autowired
    private CartItemRepository carItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    public List<CartItem> findCartItemByCartId(int cartId) {
        return carItemRepository.findCartItemByItemId(cartId);
    }

    public List<CartItem> findByItemId(int itemId) {
        return carItemRepository.findByItemId(itemId);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

	@Transactional
	public void addCart(Long cartId, Item newItem, int amount) {
	    // 현재 담긴 장바구니가 없을 때 장바구니 생성해주는 코드
	    Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
	        Cart newCart = new Cart();
	        return cartRepository.save(newCart);
	    });

	    // 장바구니에 해당 아이템이 이미 담겨져 있는지 확인
	    CartItem cartItem = carItemRepository.findByCartIdAndItemId(cartId, newItem.getId());

	    if (cartItem == null) {
	        // 장바구니에 해당 아이템이 없으면 새로운 CartItem 생성
	        cartItem = new CartItem();
	        cartItem.setId(amount);
	        cartItem.setCart(cart);
	        cartItem.setItem(newItem);
	        cartItem.setCount(amount);
	    } else {
	        // 장바구니에 해당 아이템이 이미 담겨져 있으면 수량 증가
	        cartItem.addCount(amount);
	    }

	    // 생성 또는 업데이트된 CartItem을 저장
	    carItemRepository.save(cartItem);

	 
	}
	
	//결제하기
	@Transactional
	public void checkout(Long cartId) {
		//주문할 아이템 정보를 찾기 위해 cart entity정보를 가지고 옴
		Cart cart = cartRepository.findById(cartId).orElse(null);
		//cart - 어떤 유저가 장바구니에 물건을 담앗는지
		//user - cart를 연결해주는 객체 역할을 함
		//cartItem - 장바구니에 어떤 아이템이 담겼는지
		//cart - item 연결해놓은 역할을 함
		//카트가 null값이 아닐 때
		System.out.println("*"+cart);
		if(cart !=null) {
			//order객체를 가지고 온 것임
			//builder() order에 cart를 더해준다 그결과를 build()가 가지고 있음
			//Order order=Order + cart(cart) = build()
			Order order = Order.builder().cart(cart).build();
			
			//결제이후 문제가 생길 것을 대비해서 db안에도 주문한 사람과 주문날짜와 같은 주문내역을 저장할 예정
			orderRepository.save(order);
			
			//delete clear, 주문 후 장바구니를 비우겠다.
			carItemRepository.deleteAll(); //데이터베이스 삭제
			cart.getCartItems().clear(); //배열,리스트나 set같은 컬렉션에서 리스트나 컬랙션을 초기화할 때 사용, 현재는 리스트를 사용하지 않아서 동작하지 않음  
		
			System.out.println("*"+cart);
			cartRepository.save(cart);
		}
	}
	
	
}






