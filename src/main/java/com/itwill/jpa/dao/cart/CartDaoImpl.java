package com.itwill.jpa.dao.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.repository.cart.CartRepository;

public class CartDaoImpl implements CartDao {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public void createCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart getCartById(Long cartId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAllbyUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cart> findAllCartList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}
