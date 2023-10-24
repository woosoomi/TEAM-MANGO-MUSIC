package com.itwill.jpa.service.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.vote.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepository voteRepository;

	// 투표 생성
	@Override
	public Vote createVote(Vote vote) {
		// Product 엔티티를 불러옴

		Vote creatVote = voteRepository.save(vote); // Vote 저장

		return creatVote;
	}
	
	// 전체 투표 리스트 검색
	@Override
	public List<Vote> findVoteListAll() throws Exception {
		List<Vote> findVoteList = voteRepository.findAll();
		return findVoteList;
	}
	
	//투표번호로 투표 1개 선택
	@Override
	public Object selectByVoteNo(Long no) throws Exception {
		Object selectByVoteNo = voteRepository.findById(no);
		return selectByVoteNo;
	}
	
	// 투표번호로 투표 삭제
	@Override
	public void deleteByVoteNo(Long no) throws Exception {
	voteRepository.deleteById(no);
	}
	
	
}
