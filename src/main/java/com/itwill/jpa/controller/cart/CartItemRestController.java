
package com.itwill.jpa.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.service.cart.CartItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CartItemRestController {
	
    @Autowired
    private CartItemService cartItemService;
    @Operation(summary = "장바구니에 상품추가[성공]")
    @PostMapping("/cart_main")
    public String insertCartItem(CartItemDto dto, Model model) {
    	CartItemDto insertCartItem;
        try {
        	insertCartItem = cartItemService.insert(dto);
        	model.addAttribute("inserCartItem",insertCartItem);
        	return "성공";
        } catch (Exception e) {
        	e.printStackTrace();
            return "실패";
        }
    }
    @PostMapping("/cart_main/updateQty/{cartItemId}")
    public CartItemDto updateCartItem(@PathVariable Long cartItemId, @RequestParam Integer cartItemQty) throws Exception {
    	System.out.println(cartItemId);
    	System.out.println("123123123123");
        CartItemDto updatedCartItem = cartItemService.update(cartItemId, cartItemQty);
        return updatedCartItem;
    }
    
    @Operation(summary = "상품 한개 삭제[성공]")
    @DeleteMapping("/cart_main/{cartItemId}")
    public void deleteCartItem(@PathVariable(value = "cartItemId") Long CartItemId) {
        try {
            cartItemService.deleteByCartItemId(CartItemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Operation(summary = "상품 여러개 삭제[성공]")
    @DeleteMapping("/cart_main/deleteByCartItems")
    public void deleteCartItems(@RequestBody List<Long> cartItemIds) {
        try {
            cartItemService.deleteByCartItemIds(cartItemIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
