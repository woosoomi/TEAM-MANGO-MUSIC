package com.itwill.jpa.service.cart;

import java.util.List;

import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemService {
	

	//상품 추가
	public List<CartItem> insertAll(List<CartItem> cartItems) throws Exception;
	
	//수량 수정
	public CartItem update(Long cartItemId, int qty) throws Exception;
	
	//상품 삭제
	public void deleteByCartItemId(Long cartItemId) throws Exception;
	
	
}
