package com.itwill.jpa.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.jpa.entity.user.User;

public interface UserRepository extends JpaRepository<User, String> {

	
	/*
	 * List<User> findByUserid(String user_Id);
	 * 
	 * List<User> getByUserid(String user_Id);
	 * 
	 * 
	 * List<User> findByPhone(String phone);
	 * 
	 * 
	 * List<User> findByUseridAndPhone(String user_id,String phone); List<User>
	 * findByUseridOrPhone(String user_id,String phone);
	 * 
	 * @Query(value="select * from userinfo where user_id=?1",nativeQuery = true)
	 * List<User> findByuser_idSQL(String user_id);
	 */
	 

}
