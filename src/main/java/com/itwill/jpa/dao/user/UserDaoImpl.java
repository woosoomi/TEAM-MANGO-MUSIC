package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.dto.user.UserDto;

public class UserDaoImpl implements UserDao{

	
	
	@Override
	public int create(UserDto user) throws Exception {
		
		return 0;
	}

	@Override
	public int update(UserDto user) throws Exception {
		
		return 0;
	}

	@Override
	public int remove(String user_id) throws Exception {
		
		return 0;
	}

	@Override
	public UserDto findUser(String user_id) throws Exception {
		
		return null;
	}

	@Override
	public List<UserDto> findUserList() throws Exception {
		
		return null;
	}

	@Override
	public boolean existedUser(String user_id) throws Exception {
		
		return false;
	}

}
