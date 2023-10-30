package com.itwill.jpa.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.service.cart.CartItemService;
import com.itwill.jpa.service.cart.CartItemServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartItemRestController {
	
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/insert")
    public ResponseEntity<CartItemDto> addCartItem(@RequestBody CartItemDto dto) {
        try {
            CartItemDto savedCartItem = cartItemService.insert(dto);
            return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
