package com.itwill.jpa.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.jpa.service.cart.CartServiceImpl;

@Controller
public class CartController {
	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@GetMapping("movielist_light")
	public String cart() {
		String forwardPath = "movielist_light";
		return forwardPath;
	}

	
}
