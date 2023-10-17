package com.itwill.jpa.dao.vote;

public interface VoteService {

	
	// 회원이 가수에게 투표하기
	int vote(VoteDao vote) throws Exception;
	
	// 전체 가수 투표 리스트
	// 가수 투표 상세보기
	// 투표 대상(가수?? 앨범??) 삭제
}
