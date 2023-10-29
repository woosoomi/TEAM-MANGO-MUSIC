package com.itwill.jpa.dao.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.user.UserVoteRepository;
import com.itwill.jpa.repository.vote.VoteRepository;

@Repository
public class UserVoteDaoImpl implements UserVoteDao{
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	UserVoteRepository userVoteRepository;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserVoteDao userVoteDao;

	@Override
	// 유저의 투표번호로 투표,상품전체조회
	public User findUserVoteIdWithProduct(UserVoteDto userVoteDto) {
		/*
		Vote vote = userVoteDto.getVote();
		User user = user.setVote(vote);
		userVoteRepository.findUserVoteIdWithProduct(user.getVote().getVoteId());
		*/
		return null;
	}

}