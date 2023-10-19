package com.itwill.jpa.dao.cart;

import java.util.List;

import com.itwill.jpa.entity.cart.Cart;

public interface CartDao {
	
	//새로운 카트 생성
	void createCart(Cart cart) throws Exception;
	
	//카트 정보 업데이트
	void updateCart(Cart cart) throws Exception;
	
	//cartId로 카트 정보 조회
	Cart getCartById(Long cartId) throws Exception;
	
	//userId에 담긴 카트리스트 모두삭제
	int deleteAllbyUserId(String userId) throws Exception;
	
	//모든 카트리스트 조회
	List<Cart> findAllCartList() throws Exception;
	
	

}
