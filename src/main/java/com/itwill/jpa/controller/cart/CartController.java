package com.itwill.jpa.controller.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.service.cart.CartItemService;
import com.itwill.jpa.service.cart.CartService;


@Controller
public class CartController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;
	/*
	@GetMapping("/cart")
	public String cart() {
		
		return "cart";
	}
	*/
	@GetMapping("/cart")
	public String cart(Model model) {
		try {
			CartDto cart = cartService.findCartByCartId(1L);
			List<CartItemDto> cartItems = cartItemService.findAllByCartId(cart.getCartId());
			model.addAttribute(cartItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "cart";
	}

}
