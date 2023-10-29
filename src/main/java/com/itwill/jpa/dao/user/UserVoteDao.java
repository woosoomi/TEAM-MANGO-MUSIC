package com.itwill.jpa.dao.user;

import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.user.User;

public interface UserVoteDao {

	User findUserVoteIdWithProduct(UserVoteDto userVoteDto);

    
}
