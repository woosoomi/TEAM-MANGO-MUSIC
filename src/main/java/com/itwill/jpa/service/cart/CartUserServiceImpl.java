package com.itwill.jpa.service.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.cart.CartDao;
import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartUserServiceImpl implements CartUserService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	CartItemService cartItemService;
	
	
	@Override
	public void deleteByUserIdCart(String userId) throws Exception {
		/* 1. userId를 이용하여 해당 유저의 아이디를 가지고 있는
		 * 	  장바구니 정보를 불러온다.
		 */
		Cart cart = cartRepository.findByUserId(userId);
		
		// 만약 카트번호가 비어있으면 바로 회원 삭제 진행
        if (cart==null) {
			userRepository.deleteById(userId);
			System.out.println(">>>> 회원 삭제 완료");
        }
        // 만약 카트번호가 있으면 카트삭제 후 회원 삭제 진행
        cartRepository.deleteById(cart.getCartId());
        userRepository.deleteById(userId);
        System.out.println(">>>> 회원 삭제 완료");
	}

}
