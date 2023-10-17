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
       
        return null;
    }

    @Override
    public User updateUser(User user) {
       
        return null;
    }

    @Override
    public void removeUser(String id) {
    
    }

    @Override
    public User findUser(String id) {
        
        return null;
    }

    @Override
    public List<User> findUserList() {
       
    	return null;
    }

    public boolean existedUser(String userid) {
        
        return true;
    }

}
