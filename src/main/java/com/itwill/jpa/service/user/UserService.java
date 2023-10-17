package com.itwill.jpa.service.user;

import java.util.List;

import com.itwill.jpa.entity.user.User;

public interface UserService {
		// 회원가입
		User createUser(User userid) throws Exception;

		// 회원 로그인
		int login(String userid, String password) throws Exception;
		 
		// 회원상세보기
		User findUser(String userid) throws Exception;

		// 회원수정
		int updateUser(User userid) throws Exception;
		
		// 회원탈퇴
		int removeUser(String userid) throws Exception;

		// 전체회원리스트
		List<User> findUserList() throws Exception;
		
		// 아이디중복체크
		boolean isDuplicateId(String userid) throws Exception;
}
