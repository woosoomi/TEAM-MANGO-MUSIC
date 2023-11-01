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
	        CartDto cart = cartService.findCartByCartId(1L);
	        List<CartItemDto> cartItems = cartItemService.findAllByCartId(cart.getCartId());
	        
	        // 각각의 카트 아이템에서 productId를 가져와 ProductDto를 가져오기
	        List<ProductDto> products = new ArrayList<>();
	        for (CartItemDto cartItem : cartItems) {
	            Optional<ProductDto> productOptional = cartItemService.getProductByProductId(cartItem.getProductId());
	            productOptional.ifPresent(products::add);
	        }
	        
	        model.addAttribute("cartItems", cartItems);
	        model.addAttribute("products", products);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "cart";
	}


	
	
	
	
	
	
}
