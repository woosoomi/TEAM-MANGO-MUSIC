package com.itwill.jpa.dao.vote;

import java.util.List;

import com.itwill.jpa.dto.vote.VoteDto;

public interface VoteDao {
	
	// 회원이 가수에게 투표하기
	int voteUserforArtist(VoteDto userId) throws Exception;
	
	// 투표 대상(가수?? 앨범??) 삭제
	int removeVoteArtist(VoteDto artist) throws Exception;

	// 해당가수 투표율 상세보기
	VoteDto findVoteArtist() throws Exception;
	
	// 가수 투표 전체 리스트
	List<VoteDto> findVoteArtistList () throws Exception;
	
	// 회원 투표 전체 리스트
	List<VoteDto> findVoteUserId() throws Exception;
	
	
}
