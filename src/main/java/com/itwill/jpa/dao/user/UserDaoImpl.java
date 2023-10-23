package com.itwill.jpa.dao.user;

import java.util.List;
import java.util.Optional;

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
		User createdUser = userRepository.save(user);
		return createdUser;
		
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user);
		return updatedUser;
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
	public User findUser(String userId) {
		User findedUser = userRepository.findById(userId).get();  
		return findedUser;
	}

	@Override
	public List<User> findUserList() {    
		return userRepository.findAll();
	}

	@Override
	public boolean existsById(String userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public String findUserIdByUserEmail(String userEmail) {
		String findId = userRepository.findUserIdByUserEmail(userEmail);
		return findId;
	}

	@Override
	public String findUserPwByUserPhone(String userPhone) {
		String findPw = userRepository.findUserPwByUserPhone(userPhone);
		return findPw;
	}


}