package com.itwill.jpa.controller.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.service.cart.CartItemService;
import com.itwill.jpa.service.cart.CartService;


@Controller
public class CartController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;

	@GetMapping("/cart")
	public String cart(Model model) {
	    try {
	        CartDto cart = cartService.findCartByCartId(8L);
	        List<CartItemDto> cartItems = cartItemService.findAllByCartId(cart.getCartId());
	        
	        if (cartItems.isEmpty()) {
	            return "empty_cart";
	        } else {
	    
	            List<ProductDto> products = new ArrayList<>();
	            for (CartItemDto cartItem : cartItems) {
	                Optional<ProductDto> productOptional = cartItemService.getProductByProductId(cartItem.getProductId());
	                productOptional.ifPresent(products::add);
	            }
	            
	            model.addAttribute("cart",cart);
	            model.addAttribute("cartItems", cartItems);
	            model.addAttribute("products", products);
	            return "cart"; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "index";
	    }
	}





	
	
	
}
