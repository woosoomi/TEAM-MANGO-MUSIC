package com.itwill.jpa.service.user;


import java.util.List;

import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.user.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	
	// 회원가입
	@Override
	public User createUser(User userid) throws Exception {
		if (userDao.existedUser(userid.getUserId())) {
			//중복인 경우, exception 처리 만들어야함.
		}return userDao.createUser(userid);
	}

	
	// 로그인
	@Override
	public int login(String userid, String password) throws Exception {
		
		return 0;
		
	}

	@Override
	public User findUser(String userid) throws Exception {
		
		return null;
	}

	@Override
	public int updateUser(User userid) throws Exception {
		
		return 0;
	}

	@Override
	public int removeUser(String userid) throws Exception {
		
		return 0;
	}

	@Override
	public List<User> findUserList() throws Exception {
		
		return null;
	}

	@Override
	public boolean isDuplicateId(String userid) throws Exception {
		
		return false;
	}

}
