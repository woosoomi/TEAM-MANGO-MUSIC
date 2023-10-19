package com.itwill.jpa.dao.cart;

import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemDao {

	//cartItem 추가
	CartItem insert(CartItem cartItem) throws Exception;
	
	//장바구니에 담긴 상품 수
	int cartRowCount(String userId) throws Exception;
	
	//cartitem 삭제
	int deleteByCartId(Long cartItemId) throws Exception;
	
	//cartitem 업데이트
	int updateByUserId(CartItem cartItem) throws Exception;
	
}
