package com.itwill.jpa.service.cart;

import java.util.List;
import java.util.Optional;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;

public interface CartService {
	
	//장바구니 추가
	public Cart insert(Cart cart) throws Exception;
	
	//장바구니 비우기
	public void deleteAllByCartId(Long cartId) throws Exception;
	
	//총합 계산
	public double calculateTotalPrice(List<Cart> cartItems) throws Exception;
	
	//장바구니 조회
	List<Cart> getCartItems(Cart cart) throws Exception;
	


	
	
	
	
}
