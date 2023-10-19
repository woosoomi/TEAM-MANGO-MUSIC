package com.itwill.jpa.dao.cart;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartItemRepository;

public class CartItemDaoImpl implements CartItemDao{
	
	@Autowired
	CartItemRepository cartItemRepository;
		
	@Override
	public CartItem insert(CartItem cartItem) throws Exception {
		CartItem insertCart = cartItemRepository.save(cartItem);
		return insertCart;
	}

	@Override
	public int cartRowCount(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByCartId(Long cartItemId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByUserId(CartItem cartItem) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
