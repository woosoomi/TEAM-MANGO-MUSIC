package com.itwill.jpa.service.vote;

import java.util.List;

import com.itwill.jpa.entity.vote.Vote;

public interface VoteService {
		// 투표 생성
		Vote createVote(Vote vote) throws Exception;
		
		//전체 투표 리스트 검색
		List<Vote> findVoteListAll() throws Exception;
		
		//투표번호로 투표 1개 선택
		Object selectByVoteNo(Long no) throws Exception;
}
