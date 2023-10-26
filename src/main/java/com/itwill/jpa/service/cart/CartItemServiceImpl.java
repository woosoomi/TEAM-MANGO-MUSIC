package com.itwill.jpa.service.cart;

import java.util.ArrayList;
import java.util.List;
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
	public List<CartItem> insertAll(List<CartItem> cartItems) throws Exception {
		List<CartItem> insertedItems = new ArrayList<>();
		for (CartItem cartItem : cartItems) {
			CartItem insertedCartItem = cartItemRepository.save(cartItem);
			insertedItems.add(insertedCartItem);
		}
		return insertedItems;
	}

	@Override
	public CartItem update(Long cartItemId, int qty) throws Exception {
		Optional<CartItem> findCartItem = cartItemRepository.findById(cartItemId);
		CartItem updatedCart = null;
		if (findCartItem.isPresent()) {
			CartItem cartItem = findCartItem.get();
			cartItem.setCartItemQty(qty);
			updatedCart = cartItemRepository.save(cartItem);
		}else {
			throw new Exception("존재하지 않는 장바구니입니다.");
		}
		return updatedCart;
	}

	@Override
	public void deleteByCartItemId(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);;
	}

}
