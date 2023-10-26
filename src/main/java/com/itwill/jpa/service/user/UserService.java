package com.itwill.jpa.service.user;

import java.util.List;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.user.User;

public interface UserService {
		// 회원가입
		User createUser(User user) throws Exception;
		
		//	로그인
		User loginUser(String userId, String userPw) throws Exception;
		
		// 회원수정
		User updateUser(User user) throws Exception;

		// 회원탈퇴
		void deleteUser(String userId) throws Exception;
		
		// 회원상세보기
		User findUser(String userId) throws Exception;

		// 전체회원리스트
		List<User> findUserList() throws Exception;
		
		// 아이디중복체크
		boolean existsById(String userId) throws Exception;
		
		//이메일로 아이디 찾기
		String findUserIdByUserNameUserEmail(String userName ,String userEmail) throws Exception;
		
		// 번호로 비밀번호 찾기
		String findUserPwByUserIdUserPhone(String userId, String userPhone) throws Exception; 
		
}