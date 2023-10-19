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
	
	@Override
	public User findUser(String userId) throws Exception {
		
		
		return null;
	}

	@Override
	public User updateUser(User userId) throws Exception {
		
		return null;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		
		return ;
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
	public String findUserIdByUserEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserPwByUserPhone(String userPhone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
