package com.itwill.jpa.dao.cart;

import java.util.List;

import com.itwill.jpa.entity.cart.Cart;

public interface CartDao {
	
	//새로운 카트 생성
	void createCart(Cart cart) throws Exception;
	
	//장바구니에 담긴 상품 수
	//int cartRowCount(String userId) throws Exception;
	
	//cartId로 카트 정보 조회
	Cart getCartById(Long cartId) throws Exception;
	
	//userId에 담긴 카트리스트 모두삭제
	//void deleteAllbyUserId(String userId) throws Exception;
	
	//모든 카트리스트 조회
	List<Cart> findAllCartList() throws Exception;
	
	

}
