package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.entity.user.User;

public interface UserDao {

	User createUser(User user);

    User updateUser(User user);

    void removeUser(String userId);

    User findUser(String userId);

    List<User> findUserList();
    
    int countbyId(String userId);

}