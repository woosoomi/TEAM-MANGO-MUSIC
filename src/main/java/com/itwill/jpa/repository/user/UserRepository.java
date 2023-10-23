package com.itwill.jpa.repository.user;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	  @Query(value = "SELECT u.userId FROM User u WHERE u.userEmail = :userEmail", nativeQuery = true)
	  String findUserIdByUserEmail(String userEmail);
	  
	  @Query(value = "SELECT u.userPw FROM User u WHERE u.userPhone = :userPhone", nativeQuery = true)
	  String findUserPwByUserPhone(String userPhone);
	 
}