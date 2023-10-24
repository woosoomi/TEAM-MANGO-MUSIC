package com.itwill.jpa.service.cart;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.repository.cart.CartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	/*
	@Override
	public void deleteAll(String userId) {
		cartRepository.deleteByUser_UserId(userId);
		
	}
	*/

	@Override
	public double calculateTotalPrice(Cart cart) {
		double total = 0.0;
        List<CartItem> cartItems = cart.getCartitems();

        for (CartItem cartItem : cartItems) {
            double itemPrice = cartItem.getProduct().getProductPrice();
            int quantity = cartItem.getCartItemQty();
            total += itemPrice * quantity;
        }

        return total;
	}

	@Override
	public List<Cart> getCartItems(Cart cart) {
		return cartRepository.findAll();
	}

	@Override
	public Cart insert(Cart cart) {
		return cartRepository.save(cart);
	}

	
}
