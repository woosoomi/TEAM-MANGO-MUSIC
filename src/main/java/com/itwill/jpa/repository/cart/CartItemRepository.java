package com.itwill.jpa.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.cart.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
