package com.itwill.jpa.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.repository.user.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepository;
	
	
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
