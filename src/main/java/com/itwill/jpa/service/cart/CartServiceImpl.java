package com.itwill.jpa.service.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.cart.CartDao;
import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
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
	
	@Override
	public CartDto insert(CartDto dto) throws Exception {
		User user = userRepository.findById(dto.getUserId()).orElse(null);
		Cart cart = Cart.toEntity(dto);
		cart.setUser(user);
		cart = cartRepository.save(cart);
		return CartDto.toDto(cart);
	}
	@Override
	public CartDto deleteAllByCartId(Long cartId) throws Exception {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if (cart != null) {
	        cart.getCartitems().clear(); 
	        cartRepository.save(cart);
	    }
		CartDto cartDto = CartDto.toDto(cart);
		return cartDto;
	}
	@Override
	public CartDto calculateTotalPrice(List<CartItem> cartItems) throws Exception {
		int totPrice = 0;
		for (CartItem cartItem : cartItems) {
			Product product = cartItem.getProduct();
			int qty = cartItem.getCartItemQty();

			if (product != null) {
				int productPrice = product.getProductPrice();
				totPrice += productPrice * qty;
			}
		}
		CartDto cartDto = new CartDto();
		cartDto.setCartTotPrice(totPrice);
		return cartDto;
	}
	/*
	@Override
	public List<CartDto> getCartItems(CartDto dto) throws Exception {
		List<Cart> carts = cartRepository.findAll();
	    List<CartDto> cartDtos = new ArrayList<>();
	    for (Cart cart : carts) {
	        CartDto cartDto = CartDto.toDto(cart);
	        cartDtos.add(cartDto);
	    }
	    return cartDtos;
	}
	*/
	/*
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
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if (cart != null) {
	        cart.getCartitems().clear(); // 카트 아이템 리스트를 비웁니다.
	        cartRepository.save(cart); // 변경사항을 저장합니다.
	    }
	}
	// 장바구니에 담긴 상품들 총액계산
	@Override
	public int calculateTotalPrice(List<CartItem> cartItems) {
		int totPrice = 0;
		for (CartItem cartItem : cartItems) {
			Product product = cartItem.getProduct();
			int qty = cartItem.getCartItemQty();

			if (product != null) {
				int productPrice = product.getProductPrice();
				totPrice += productPrice * qty;
			}
		}
		return totPrice;
	}
	*/
}
