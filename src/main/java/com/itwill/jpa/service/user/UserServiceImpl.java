package com.itwill.jpa.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) throws Exception {
		return null;
	}
	
	@Override
	public User loginUser(String userId, String userPw) throws Exception {
		return null;
	}

	@Override
	public User updateUser(User user) throws Exception {
		return null;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		Optional<User> selectedUserOptional = userRepository.findById(userId);
		if(selectedUserOptional.isEmpty()) {
			throw new Exception("존재하지 않는 아이디입니다.");
		}
		userRepository.delete(selectedUserOptional.get());
	}

	@Override
	public User findUser(String userId) throws Exception {
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		return null;
	}

	@Override
	public boolean existsById(String userId) throws Exception {
		return false;
	}

	@Override
	public String findUserIdByUserEmail(String userEmail) throws Exception {
		return null;
	}

	@Override
	public String findUserPwByUserPhone(String userPhone) throws Exception {
		return null;
	}

	
	
}
