package com.itwill.jpa.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public User createUser(User user) throws Exception {
		if(userDao.existsById(user.getUserId())) {
			throw new Exception(user.getUserId() + "는 이미 존재하는 아이디입니다.");
		}
		
		User insert = userDao.createUser(user);
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
		 if (userDao.existsById(user.getUserId())) {
	            return userDao.updateUser(user);
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
	public String findUserIdByUserNameUserEmail(String userName, String userEmail) throws Exception {
	    if (userName == null || userName.isEmpty()) {
	        throw new Exception("사용자 이름이 잘못되었습니다.");
	    }
	    if (userEmail == null || userEmail.isEmpty()) {
	        throw new Exception("사용자 이메일이 잘못되었습니다.");
	    }
	    String userId = userDao.findUserIdByUserNameUserEmail(userName, userEmail);
	    if (userId == null) {
	        throw new Exception("해당 정보로 등록된 사용자가 없습니다.");
	    }
	    return userId;
	}

	@Override
	public String findUserPwByUserIdUserPhone(String userId, String userPhone) throws Exception {
		if (userId == null || userId.isEmpty()) {
			throw new Exception("사용자 아이디가 잘못되었습니다.");
		}
		if (userPhone == null || userPhone.isEmpty()) {
			throw new Exception("사용자 번호가 잘못되었습니다.");
		}

		String userPw = userRepository.findUserPwByUserIdUserPhone(userId, userPhone);
		if (userPw == null) {
			throw new Exception("해당 정보로 등록된 사용자가 없습니다.");
		}
		return userPw;
	}
	
//    @Override
//    public User findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
}
	
	

