package com.itwill.jpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
	@SequenceGenerator(name = "USER_USER_NO_SEQ",sequenceName = "USER_USER_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_USER_NO_SEQ")
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
	
	//user -userboard 1대n
	@OneToMany(mappedBy = "user",  cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<User_Board> userBoard = new ArrayList<User_Board>();
	
	//user -order 1대n
	@OneToMany(mappedBy = "user",  cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Order> order =new ArrayList<Order>();
	
	//product와 vote 1대n
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Vote> vote = new ArrayList<Vote>();
	
} 




	
