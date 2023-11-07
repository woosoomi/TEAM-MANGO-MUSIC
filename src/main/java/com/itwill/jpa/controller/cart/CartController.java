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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class CartController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;

	@GetMapping("/cart_main")
	public String cart(Model model, HttpServletRequest request) {
	    try {
	    	
	    	/*오더의 손길*/
			//임의로 세션 로그인 유저 설정함
			HttpSession session = request.getSession();
			session.setAttribute("user_id", "lsg33");
			String userId = (String) session.getAttribute("user_id");
			model.addAttribute("user_id", userId);
	    	
	        CartDto cart = cartService.findCartByCartId(1L);
	        List<CartItemDto> cartItems = cartItemService.findAllByCartId(cart.getCartId());
	        
	        if (cartItems.isEmpty()) {
	            return "cart_empty";
	        } else {
	    
	            List<ProductDto> products = new ArrayList<>();
	            for (CartItemDto cartItem : cartItems) {
	                Optional<ProductDto> productOptional = cartItemService.getProductByProductId(cartItem.getProductId());
	                productOptional.ifPresent(products::add);
	            }
	            
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
