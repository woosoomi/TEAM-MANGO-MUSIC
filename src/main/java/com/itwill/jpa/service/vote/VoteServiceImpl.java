package com.itwill.jpa.service.vote;

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
	
	@Autowired
    private ProductRepository productRepository;
	
	@Override
	public Vote createVote(Vote vote) {
	    // Product 엔티티를 불러옴
	  
	        voteRepository.save(vote); // Vote 저장
	   
		return vote;
	}

}
