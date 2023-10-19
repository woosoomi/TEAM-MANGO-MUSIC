package com.itwill.jpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Table(name = "userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id 
	//@Column(name = "user_Id")
	private String userId;			// 회원 아이디
	
	@Column(length = 10, nullable = false)
	private String userPw;			// 회원 비밀번호
	
	private String userName;		// 회원 이름
	
	@Column(length = 13, nullable = false)
	private String userPhone;		// 회원 전화번호
	
	private String userAddress;	    // 회원 주소
	private String userEmail;		// 회원 이메일
	private String userJumin;		// 회원 주민번호
	private String userGender;		// 회원 성별
	
	// user와 board 1대N 관계설정
	@Builder.Default
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Board> boards = new ArrayList<>();
	
//	// user와 order 1대N 관계설정
//	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//	private List<Order> orders = new ArrayList<>();
//	
//	// user와 cart 1대N 관계설정
//	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//	private List<Cart> carts = new ArrayList<>();
//	
//	// user와 product N대1 관계설정
//	@ManyToOne
//	@JoinColumn(name = "product_no")
//	private Product product = new Product();
	
	
}




	
