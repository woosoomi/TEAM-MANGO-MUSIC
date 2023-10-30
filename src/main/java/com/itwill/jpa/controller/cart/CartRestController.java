package com.itwill.jpa.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.service.cart.CartItemServiceImpl;
import com.itwill.jpa.service.cart.CartService;
import com.itwill.jpa.service.cart.CartServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartRestController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CartServiceImpl cartServiceImpl;
	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
	@Operation(summary = "장바구니생성")
    @PostMapping("/create")
    public String createCart(CartDto dto, Model model) {
    	CartDto createCart;
		try {
			createCart = cartServiceImpl.createCart(dto);
		  	model.addAttribute("insertCart",createCart);  
	    	System.out.println("insertCart :"+createCart);
	    	return "cart";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
    @Operation(summary = "장바구니 상품전체삭제")
    @DeleteMapping("/cart/{cartId}")
    public String deleteAllItemsInCart(@PathVariable(value = "cartId") Long cartId) {
        try {
            CartDto deletedCart = cartServiceImpl.deleteAllByCartId(cartId);
            return "삭제완료";
        } catch (Exception e) {
            e.printStackTrace();
            return "삭제실패";
        }
    }
    @Operation(summary = "총액 업데이트")
    @PostMapping("/calculateTotalPrice")
    public ResponseEntity<CartDto> calculateTotalPrice(@RequestBody List<CartItemDto> cartItemDtos) {
        try {
            CartDto cartDto = cartService.calculateTotalPrice(cartItemDtos);
            return ResponseEntity.ok(cartDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
  
}
