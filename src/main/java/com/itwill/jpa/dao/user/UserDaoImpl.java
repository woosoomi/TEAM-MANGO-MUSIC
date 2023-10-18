package com.itwill.jpa.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countbyId(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserIdByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserpasswByPhone(String userPhone) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

