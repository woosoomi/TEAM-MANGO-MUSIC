package com.itwill.jpa.service.cart;

import java.util.List;

import com.itwill.jpa.entity.cart.Cart;

public interface CartService {
	
	//public Cart insert(Cart cart);
	
	//장바구니 비우기
	public void deleteAll(List<Cart> cartList) throws Exception;
	
	//총합 계산
	public double calculateTotalPrice(Cart cart) throws Exception;
	
	//장바구니 조회
	List<Cart> getCartItems(Cart cart) throws Exception;
	
	
	
}
