package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.entity.user.User;

public interface UserDao {

	User createUser(User user);

    User updateUser(User user);

    void deleteUser(String userId);

    User findUser(String userId);

    List<User> findUserList();
    
    boolean existsById(String userId); //중복된 아이디
    
    User findUserIdByEmail(String userEmail); // 이메일로 아이디 찾기

    User findUserpasswByPhone(String userPhone); // 번호로 비밀번호 찾기
    
    
    
    
}