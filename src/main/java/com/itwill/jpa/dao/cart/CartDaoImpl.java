package com.itwill.jpa.dao.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartRepository;

public class CartDaoImpl implements CartDao {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public void createCart(Cart cart) throws Exception {
		cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart updateCart) throws Exception {
		Optional<Cart> findcartOptional = cartRepository.findById(updateCart.getCartId());
		Cart updatedCart = null;
		if (findcartOptional.isPresent()) {
			Cart cart = findcartOptional.get();
			cart.getCartItemDto().setCartItemQty(updateCart.getCartItemDto().getCartItemQty());
			updateCart = cartRepository.save(cart);
	
		}else {
			throw new Exception("존재하지 않는 장바구니입니다.");
		}
		return updatedCart;
	}

	@Override
	public void deleteAllbyUserId(String userId) throws Exception {
		cartRepository.deleteAllByUserId(userId);
	}

	@Override
	public List<Cart> findAllCartList() throws Exception {
		return cartRepository.findAll();
	}




}
