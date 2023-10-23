package com.itwill.jpa.service.cart;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Override
	public CartItem insert(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem update(CartItem updateCartItem) throws Exception {
		Optional<CartItem> findCartOptional = cartItemRepository.findById(updateCartItem.getCartItemId());
		CartItem updatedCart = null;
		if (findCartOptional.isPresent()) {
			CartItem cartItem = findCartOptional.get();
			cartItem.setCartItemQty(updateCartItem.getCartItemQty());
			updatedCart = cartItemRepository.save(cartItem);
		}else {
			throw new Exception("존재하지 않는 장바구니입니다.");
		}
		return updatedCart;
	}

	@Override
	public void delete(Long cartItemId) {
		// TODO Auto-generated method stub
		
	}

}
