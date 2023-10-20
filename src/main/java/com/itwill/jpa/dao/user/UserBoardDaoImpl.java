package com.itwill.jpa.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.user.UserBoard;
import com.itwill.jpa.repository.user.UserBoardRepository;

@Repository
public class UserBoardDaoImpl implements UserBoardDao {
	
	@Autowired
	UserBoardRepository userBoardRepository;

	@Override
	public UserBoard createUserBoard(UserBoard userBoard) {
		UserBoard createdUserBoard = userBoardRepository.save(userBoard);
		return createdUserBoard;
	}

	@Override
	public UserBoard updateUserBoard(UserBoard userBoard) {
		UserBoard updateUserBoard = userBoardRepository.save(userBoard);
		if(updateUserBoard != null) {
		}
		
		return updateUserBoard;
	}

	@Override
	public void deleteUserBoard(Long userBoardId) throws Exception {
		Optional<UserBoard> selectedUserBoardOptional = userBoardRepository.findById(userBoardId);
		if(selectedUserBoardOptional.isEmpty()) {
			throw new Exception("존재하지 않습니다");
		}
		userBoardRepository.delete(selectedUserBoardOptional.get());
	}

	@Override
	public UserBoard findUserBoard(Long userBoardId) {
		UserBoard findedUserBoard = userBoardRepository.findById(userBoardId).get();
		return findedUserBoard;
	}

	@Override
	public List<UserBoard> findAllUserBoards() {
		return userBoardRepository.findAll();
	}
	
	
	
}
