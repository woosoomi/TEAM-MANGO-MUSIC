package com.itwill.jpa.service.vote;

import com.itwill.jpa.entity.vote.Vote;

public interface VoteService {
		// 투표 생성
		Vote createVote(Vote vote) throws Exception;
		
}
