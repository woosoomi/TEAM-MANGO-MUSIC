package com.itwill.jpa.service.user;


import java.util.List;

import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.user.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	// 회원가입
	@Override
	public User createUser(User userId) throws Exception {
		
		return userDao.createUser(userId);
	}
	
	// 로그인
	@Override
	public int login(String userId, String password) throws Exception {
		
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		
		return null;
	}

	@Override
	public int updateUser(User userId) throws Exception {
		
		return 0;
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		
		return 0;
	}

	@Override
	public List<User> findUserList() throws Exception {
		
		return null;
	}

	@Override
	public boolean existsById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserIdByEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserpasswByPhone(String userPhone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
