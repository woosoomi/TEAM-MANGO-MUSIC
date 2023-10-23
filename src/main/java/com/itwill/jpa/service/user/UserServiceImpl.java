package com.itwill.jpa.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) throws Exception {
		User insert =  userRepository.save(user);
		return insert;
	}
	
	@Override
	public User loginUser(String userId, String userPw) throws Exception {
	      Optional<User> selectedUserOptional = userRepository.findById(userId);
	       if (selectedUserOptional.isEmpty()) {
	           throw new Exception("존재하지 않는 아이디입니다.");
	       }
	       User selectedUser = selectedUserOptional.get();

	       if (!selectedUser.getUserPw().equals(userPw)) {
	           throw new Exception("비밀번호가 일치하지 않습니다.");
	       }

	       return selectedUser;
	   }

	@Override
	public User updateUser(User user) throws Exception {
		 if (userRepository.existsById(user.getUserId())) {
	            return userRepository.save(user);
	        } else {
	            throw new Exception("존재하지 않는 사용자입니다.");
	        }
	    }

	@Override
	public void deleteUser(String userId) throws Exception {
		 Optional<User> userOptional = userRepository.findById(userId);
	        if (userOptional.isPresent()) {
	            userRepository.delete(userOptional.get());
	        } else {
	            throw new Exception("존재하지 않는 아이디입니다.");
	        }
	    }

	@Override
	public User findUser(String userId) throws Exception {
		  Optional<User> userOptional = userRepository.findById(userId);
	        if (userOptional.isEmpty()) {
	            throw new Exception("존재하지 않는 아이디입니다.");
	        }
	        return userOptional.get();
	    }

	@Override
	public List<User> findUserList() throws Exception {
		   return userRepository.findAll();
    }

	@Override
	public boolean existsById(String userId) throws Exception {
		return userRepository.existsById(userId);
		
	}

	@Override
	public String findUserIdByUserEmail(String userEmail) throws Exception {
		 String userId = userRepository.findUserIdByUserEmail(userEmail);
	        if (userId == null) {
	            throw new Exception("해당 이메일로 등록된 사용자가 없습니다.");
	        }
	        return userId;
	    }

	@Override
	public String findUserPwByUserPhone(String userPhone) throws Exception {
		  String userPw = userRepository.findUserPwByUserPhone(userPhone);
	        if (userPw == null) {
	            throw new Exception("해당 전화번호로 등록된 사용자가 없습니다.");
	        }
	        return userPw;
	    }
	}
	
	

