package com.itwill.jpa.controller.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.service.cart.CartItemService;
import com.itwill.jpa.service.cart.CartService;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class CartController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;
	@Autowired
	UserService userService;

	@GetMapping("/cart_main")
	public String cart(Model model, HttpSession session) {
	    try {
	    	
			String loginUser = (String) session.getAttribute("sUserId");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>"+loginUser);
			UserDto user = null;

			if (loginUser != null) {
				user = userService.findUser(loginUser);
				System.out.println(">>>>>>>>>>>>>"+user);
			}
			session.setAttribute("loginUser", user);
			String userIdString = (user != null) ? user.getUserId() : null;
			model.addAttribute("userIdString", userIdString);
			System.out.println(">>>>>>>>>>>>>>>>"+userIdString);
			
	        CartDto cart = cartService.findCartByCartId(7L);
	        List<CartItemDto> cartItems = cartItemService.findAllByCartId(cart.getCartId());
	        
	        if (cartItems.isEmpty()) {
	            return "cart_empty";
	        } else {
	    
	            List<ProductDto> products = new ArrayList<>();
	            for (CartItemDto cartItem : cartItems) {
	                Optional<ProductDto> productOptional = cartItemService.getProductByProductId(cartItem.getProductId());
	                productOptional.ifPresent(products::add);
	            }
	            model.addAttribute("sUser_id", loginUser);
	            model.addAttribute("cart",cart);
	            model.addAttribute("cartItems", cartItems);
	            model.addAttribute("products", products);
	            return "cart_main"; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "index";
	    }
	}
	
	
}
