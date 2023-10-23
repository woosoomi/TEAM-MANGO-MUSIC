package com.itwill.jpa.service.cart;

import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemService {
	
	//상품 추가
	public CartItem insert(CartItem cartItem) throws Exception;
	
	//수량 수정
	public CartItem update(CartItem cartItem) throws Exception;
	
	//상품 삭제
	public void deleteCartItemByUserIdAndCartItemId(String userId, Long cartItemId) throws Exception;
	
	
}
