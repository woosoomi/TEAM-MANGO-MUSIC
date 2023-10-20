package com.itwill.jpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@Column(length = 15, nullable = false)
	private String userPhone;		// 회원 전화번호
	
	private String userAddress;	    // 회원 주소
	private String userEmail;		// 회원 이메일
	private String userJumin;		// 회원 주민번호
	private String userGender;		// 회원 성별
	
	
	  // user와 user_board 1대N 관계설정
	  @Builder.Default
	  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	  private List<UserBoard> user_Boards = new ArrayList<>();
	  
	  // user와 order 1대N 관계설정
	  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	  private List<Order> orders = new ArrayList<>();
	  
	  // user와 coupon 1대N 관계설정
	  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	  private List<Coupon> coupons = new ArrayList<>();
	  
	  // user와 vote 1대N 관계설정
	  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	  private List<Vote> votes = new ArrayList<>();
	  
	  // user와 cart 1대1 관계설정
	  @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	  @JoinColumn(name="cart_id")
	  private Cart cart ;
	  
	 
}