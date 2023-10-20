//package com.itwill.jpa.dao.vote;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.itwill.jpa.dto.vote.VoteDto;
//import com.itwill.jpa.entity.vote.Vote;
//import com.itwill.jpa.repository.vote.VoteRepository;
//
//public class VoteDaoImpl implements VoteDao{
//	
//	@Autowired
//	VoteRepository voteRepository;
//
//	// 투표 생성
//	@Override
//	public Vote createVote(Vote vote) throws Exception {
//		Vote createVote = voteRepository.save(vote);
//		return createVote;
//		
//		
//	}
//	
//	// 투표 번호로 1개 선택
//	@Override
//	public Vote selectByVoteNo(Vote vote) throws Exception {
//		Vote selectByVoteNo = voteRepository.findById(vote.getVoteNo()).get();
//		
//		return selectByVoteNo;
//	}
//
//	
////	@Override
////	public Vote voteUserforArtist(Vote vote) throws Exception {
////		voteRepository.findByUserId(vote.getUser().getUserId());
////		
////		
////		return null;
////	}
//
//	@Override
//	public Vote removeVoteByArtist(Vote vote) throws Exception {
//		
//		return null;
//	}
//
//	@Override
//	public VoteDto findVoteArtist() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<VoteDto> findVoteArtistList() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<VoteDto> findVoteUserId() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//}
