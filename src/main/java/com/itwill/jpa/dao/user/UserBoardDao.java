package com.itwill.jpa.dao.user;

import java.util.List;

import com.itwill.jpa.entity.user.UserBoard;

public interface UserBoardDao {
	
	UserBoard createUserBoard(UserBoard userBoard);

    UserBoard updateUserBoard(UserBoard userBoard);

    void deleteUserBoard(Long userBoardId) throws Exception;

    UserBoard findUserBoard(Long userBoardId);

    List<UserBoard> findAllUserBoards();
}
