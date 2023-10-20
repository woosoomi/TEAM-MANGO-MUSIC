package com.itwill.jpa.entity.cart;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.cart.VoteDto;
import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartItemId;
	private int cartItemQty;
	private Product product;
	@CreationTimestamp
	private LocalDateTime createAt;
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	private VoteDto cart;
	
	public static CartItem toEntity(CartItemDto dto) {
    	return CartItem.builder()
    					.build();
    }
}
