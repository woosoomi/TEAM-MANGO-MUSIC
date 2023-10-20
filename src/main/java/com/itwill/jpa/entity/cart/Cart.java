package com.itwill.jpa.entity.cart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	@Id
	@SequenceGenerator(name = "CART_CART_NO_SEQ",sequenceName = "CART_CART_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_CART_NO_SEQ")
	private Long cartId;
	
	private int cartTotPrice;
	
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    public static Cart toEntity(CartDto dto) {
    	return Cart.builder()
    				.cartTotPrice(dto.getCartTotPrice())
    				.build();
    }
    
	//product와 cartitem 1대n
	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<CartItem> cartitems = new ArrayList<CartItem>();
    
	//user- cart 1대1
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_no")
	private User user;
}
