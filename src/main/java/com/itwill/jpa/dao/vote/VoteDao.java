package com.itwill.jpa.dao.vote;

import java.util.List;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;

public interface VoteDao {
	
		// 투표 생성 --> service 구현 완료
		Vote createVote(Vote vote) throws Exception;
		
		//투표번호로 투표 1개 선택 --> service 구현 완료
		Object selectByVoteNo(Long no) throws Exception;
		
		//투표번호로 투표 1개 삭제 --> service 구현 완료
		void deleteByVoteNo(Long no) throws Exception;
		
		//전체 투표 리스트 검색 --> service 구현 완료
		List<Vote> findVoteListAll() throws Exception;
		
		// 회원이 가수에게 투표하기
		Vote voteUserforArtist(Vote voteNo) throws Exception;
		
		// 투표 대상(가수?? 앨범??) 삭제
		Vote removeVoteByArtist(Vote userid) throws Exception;

		// 해당가수 투표율 상세보기
		VoteDto findVoteArtist() throws Exception;
		
		// 가수 투표 전체 리스트
		List<VoteDto> findVoteArtistList () throws Exception;
		
		// 회원 투표 전체 리스트
		List<VoteDto> findVoteUserId() throws Exception;
		
	
	
}
