package com.itwill.jpa.dto.user;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */

public class UserDto {
	
	private String userid;			// 회원 아이디
	private String userpw;			// 회원 비밀번호
	private String username;		// 회원 이름
	private String useraddress;	// 회원 주소
	private String useremail;		// 회원 이메일
	private String userjumin;		// 회원 주민번호
	private String userphone;		// 회원 전화번호
	private String usergender;		// 회원 성별
	
	public UserDto() {
		
	}

	public UserDto(String userid, String userpw, String username, String useraddress, String useremail,
			String userjumin, String userphone, String usergender) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useraddress = useraddress;
		this.useremail = useremail;
		this.userjumin = userjumin;
		this.userphone = userphone;
		this.usergender = usergender;
	}
	
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpw() {
		return userpw;
	}


	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseraddress() {
		return useraddress;
	}


	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserjumin() {
		return userjumin;
	}


	public void setUserjumin(String userjumin) {
		this.userjumin = userjumin;
	}


	public String getUserphone() {
		return userphone;
	}


	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}


	public String getUsergender() {
		return usergender;
	}


	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useraddress="
				+ useraddress + ", useremail=" + useremail + ", userjumin=" + userjumin + ", userphone=" + userphone
				+ ", usergender=" + usergender + "]";
	}
	
}







