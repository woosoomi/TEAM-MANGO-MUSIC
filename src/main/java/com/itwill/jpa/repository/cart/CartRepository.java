package com.itwill.jpa.repository.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	 int deleteAllByUserId(String userId);
	 Optional<Cart> findByUserId(String userId);
}
