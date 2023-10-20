package com.itwill.jpa.dto.cart;


import java.util.List;

import com.itwill.jpa.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartDto {
	
	private int cartNo;
<<<<<<< HEAD
	private int cartTotPrice;
=======
	private User user;
	private List<CartItemDto> cartItems;
>>>>>>> branch 'master' of https://github.com/2023-05-JAVA-DEVELOPER-143/2023-05-JAVA-DEVELOPER-final-project-team1-mango.git
}
