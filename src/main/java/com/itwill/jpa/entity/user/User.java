package com.itwill.jpa.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
@Table(name = "users") // 테이블 이름 임의로 지은거라서 수정 필요 ex) UserInfo..ect
public class User {

	@Id 
	@Column(name = "user_id")
	private String user_id;			// 회원 아이디
	
	@Column(length = 255, nullable = false)
	private String user_pw;			// 회원 비밀번호
	
	@Column(length = 255, nullable = false)
	private String user_name;		// 회원 이름

	@Column(length = 255, nullable = false)
	private String user_phone;		// 회원 전화번호

	@Column(length = 255, nullable = false)
	private String user_address;	// 회원 주소
	private String user_email;		// 회원 이메일
	private String user_jumin;		// 회원 주민번호 --> 요즘은 없는 추세로 추가 삭제 고민필요
	private String user_gender;		// 회원 성별
}
	
