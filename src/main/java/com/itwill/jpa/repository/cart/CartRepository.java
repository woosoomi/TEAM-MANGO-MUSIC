package com.itwill.jpa.repository.cart;


import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	//int deleteAllByUserId(String userId);
}
