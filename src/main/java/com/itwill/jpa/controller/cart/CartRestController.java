package com.itwill.jpa.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.service.cart.CartItemServiceImpl;
import com.itwill.jpa.service.cart.CartServiceImpl;

@RestController
public class CartRestController {
	/*
	@Autowired
	CartServiceImpl cartServiceImpl;
	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
    @GetMapping("/cart")
    public String insertCart(CartDto dto, Model model) {
    	CartDto insertCart;
		try {
			insertCart = cartServiceImpl.insert(dto);
		  	model.addAttribute("insertCart",insertCart);  
	    	System.out.println("insertCart :"+insertCart);
	    	return "cart";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
		*/
  
}
