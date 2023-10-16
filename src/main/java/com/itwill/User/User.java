package com.itwill.User;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */

public class User {
	
	private String user_id;			// 회원 아이디
	private String user_pw;			// 회원 비밀번호
	private String user_name;		// 회원 이름
	private String user_address;	// 회원 주소
	private String user_email;		// 회원 이메일
	private String user_jumin;		// 회원 주민번호
	private String user_phone;		// 회원 전화번호
	private String user_gender;		// 회원 성별
	

	public User() {
		
	}


	public User(String user_id, String user_pw, String user_name, String user_address, String user_email,
			String user_jumin, String user_phone, String user_gender) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_email = user_email;
		this.user_jumin = user_jumin;
		this.user_phone = user_phone;
		this.user_gender = user_gender;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_address() {
		return user_address;
	}


	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_jumin() {
		return user_jumin;
	}


	public void setUser_jumin(String user_jumin) {
		this.user_jumin = user_jumin;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public String getUser_gender() {
		return user_gender;
	}


	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_address="
				+ user_address + ", user_email=" + user_email + ", user_jumin=" + user_jumin + ", user_phone="
				+ user_phone + ", user_gender=" + user_gender + "]";
	}

	
}







