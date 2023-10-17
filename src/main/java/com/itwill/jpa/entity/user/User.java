package com.itwill.jpa.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id 
	//@Column(name = "userid")
	private String userid;			// 회원 아이디
	
	@Column(length = 10, nullable = false)
	private String userpw;			// 회원 비밀번호
	private String username;		// 회원 이름
	private String userphone;		// 회원 전화번호
	private String useraddress;	    // 회원 주소
	private String useremail;		// 회원 이메일
	private String userjumin;		// 회원 주민번호
	private String usergender;		// 회원 성별
}
	
