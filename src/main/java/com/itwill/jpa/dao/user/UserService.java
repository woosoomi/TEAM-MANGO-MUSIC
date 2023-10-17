package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.dto.user.User;

public interface UserService {

	// 회원가입
	int create(User user_id) throws Exception;

	// 회원 로그인
	int login(String user_id, String password) throws Exception;
	 
	// 회원상세보기
	User finduser_id(String user_id) throws Exception;

	// 회원수정
	int update(User user_id) throws Exception;
	
	// 회원탈퇴
	int remove(String user_id) throws Exception;

	// 전체회원리스트
	List<User> finduser_idList() throws Exception;
	
	// 아이디중복체크
	boolean isDuplicateId(String user_id) throws Exception;

}