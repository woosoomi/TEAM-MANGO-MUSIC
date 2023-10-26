//package com.itwill.jpa.service.cart;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.itwill.jpa.TeamProjectMangoApplicationTest;
//import com.itwill.jpa.entity.cart.Cart;
//import com.itwill.jpa.entity.cart.CartItem;
//import com.itwill.jpa.entity.user.User;
//import com.itwill.jpa.repository.cart.CartItemRepository;
//import com.itwill.jpa.repository.cart.CartRepository;
//import com.itwill.jpa.repository.user.UserRepository;
//
//class CartServiceImplTest extends TeamProjectMangoApplicationTest {
//
//	@Autowired
//	CartServiceImpl cartServiceImpl;
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	CartItemRepository cartItemRepository;
//	
//	@Autowired
//	CartRepository cartRepository;
//	@Test
//	void cartInsert() {
//		Cart cart1 = new Cart();
//		CartItem cartItem =new CartItem(3L,1000,null,null);
//		User user =new User("한영1","1111","한영","010-1111","안양","why","960410","남", null, null, null, null);
//		
//		
//		cart1.setUser(user);
//		cart1.getCartitems();
//		cart1.setCartId(0L);
//		cart1.setCartTotPrice(1000);
//		
//		cartRepository.save(cart1);
//		cartItemRepository.save(cartItem);
//		userRepository.save(user);
//		
//		Cart inserCart=cartServiceImpl.insert(cart1);
//		System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+inserCart);
//		
//		Cart cart2 = new Cart();
//		CartItem cartItem2 =new CartItem(4L,10000,null,null);
//		User user2 =new User("한영2","11112","한영2","010-11112","안양2","why2","9604102","남", null, null, null, null);
//		
//		
//		cart1.setUser(user2);
//		cart1.getCartitems();
//		cart1.setCartId(0L);
//		cart1.setCartTotPrice(78000);
//		
//		cartRepository.save(cart2);
//		cartItemRepository.save(cartItem2);
//		userRepository.save(user2);
//		
//		Cart inserCart1=cartServiceImpl.insert(cart2);
//		System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+inserCart1);
//	}
//	/*
//	@Test
//	void cartDelete() {
//		cartServiceImpl.deleteAll("123");
//	}
//	*/
//}
