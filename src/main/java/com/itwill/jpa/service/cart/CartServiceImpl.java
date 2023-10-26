package com.itwill.jpa.service.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;

	// 장바구니 생성
	@Override
	public Cart insert(Cart cart) {
		return cartRepository.save(cart);
	}

	// 장바구니에 담긴 상품들 조회
	@Override
	public List<Cart> getCartItems(Cart cart) {
	 	return cartRepository.findAll();
	}

	// 카트번호를 이용하여 장바구니 아이템 전체삭제
	@Override
	public void deleteAllByCartId(Long cartId) {
		cartRepository.deleteById(cartId);
	}

	// 장바구니에 담긴 상품들 총액계산
	@Override
	public double calculateTotalPrice(List<Cart> cartItems) {
		double total = 0.0;
		
		for (Cart cart : cartItems) {
			List<CartItem> findCartItems = cart.getCartitems();
			for (CartItem cartItem : findCartItems) {
				double itemPrice = cartItem.getProduct().getProductPrice();
				int quantity = cartItem.getCartItemQty();
				total += itemPrice * quantity;
			}
		}

		return total;
	}

}
