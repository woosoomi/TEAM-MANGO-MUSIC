package com.itwill.jpa.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private String userid;			// 회원 아이디
	private String userpw;			// 회원 비밀번호
	private String username;		// 회원 이름
	private String useraddress;		// 회원 주소
	private String useremail;		// 회원 이메일
	private String userjumin;		// 회원 주민번호
	private String userphone;		// 회원 전화번호
	private String usergender;		// 회원 성별
	
}







