package com.itwill.jpa.service.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public CartItemDto insert(CartItemDto dto) throws Exception {
		Product product = productRepository.findById(dto.getProduct().getProductNo()).orElse(null);
		Cart cart = cartRepository.findById(dto.getCartId()).orElse(null);
		CartItem cartItem = CartItem.toEntity(dto);
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem=cartItemRepository.save(cartItem);
		return CartItemDto.toDto(cartItem);
	}

	@Override
	public CartItemDto update(Long cartItemId, int qty) throws Exception {
		Optional<CartItem> findCartItem = cartItemRepository.findById(cartItemId);
		CartItem updatedCart = null;
		if (findCartItem.isPresent()) {
			CartItem cartItem = findCartItem.get();
			cartItem.setCartItemQty(qty);
			updatedCart = cartItemRepository.save(cartItem);
			return CartItemDto.toDto(updatedCart);
		}else {
			throw new Exception("존재하지 않는 장바구니입니다.");
		}
	}

	@Override
	public void deleteByCartItemId(Long cartItemId) throws Exception {
		cartItemRepository.deleteById(cartItemId);
	}
	
	
	
	/*
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
*/
}
