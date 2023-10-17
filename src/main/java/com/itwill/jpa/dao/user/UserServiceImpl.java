package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.dto.user.UserDto;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	
	// 회원가입
	@Override
	public int create(UserDto user_id) throws Exception {
		if (userDao.existedUser(user_id.getUser_id())) {
			//중복인 경우, exception 처리 만들어야함.
		}return userDao.create(user_id);
	}

	
	// 로그인
	@Override
	public int login(String user_id, String password) throws Exception {
		UserDto user = userDao.findUser(user_id);
		UserDto fUser = new UserDto(user_id, password, "", "", "", "", "", "");
		if (user==null) {
			
		}if (user.equals(password)) {
			
		}
		
		return 0;
		
	}

	@Override
	public UserDto finduser_id(String user_id) throws Exception {
		
		return null;
	}

	@Override
	public int update(UserDto user_id) throws Exception {
		
		return 0;
	}

	@Override
	public int remove(String user_id) throws Exception {
		
		return 0;
	}

	@Override
	public List<UserDto> finduser_idList() throws Exception {
		
		return null;
	}

	@Override
	public boolean isDuplicateId(String user_id) throws Exception {
		
		return false;
	}

}
