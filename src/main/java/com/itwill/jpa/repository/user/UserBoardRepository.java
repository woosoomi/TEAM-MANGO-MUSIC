package com.itwill.jpa.repository.user;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.user.UserBoard;

@Repository
public interface UserBoardRepository extends JpaRepository<UserBoard, Long> {
	 

}
