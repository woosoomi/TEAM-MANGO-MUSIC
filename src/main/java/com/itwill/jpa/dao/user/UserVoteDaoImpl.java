package com.itwill.jpa.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;

import com.itwill.jpa.repository.user.UserVoteRepository;
import com.itwill.jpa.repository.vote.VoteRepository;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.vote.VoteServiceImpl;

@Repository
@Service
public class UserVoteDaoImpl implements UserVoteDao{
	
	@Autowired
    private ProductRepository productRepository;	
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Autowired 
	VoteServiceImpl voteServiceImpl;
	
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

	@Override
	public String findUserVoteId(Long voteId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* findProductVoteId 
	  --> product의 voteId로 product와 Vote 전체 호출 */
	@Override
	public String findProductVoteId(Long voteId) {
	 
		//List<Object> aa = productVoteRepository.findProductVoteId(voteId);
		
		
		return null;
	}

	
	/* findProductVoteIdWithUser 
	   --> product의 voteId로 User와 Vote 전체 호출	*/
	@Override
	public Product findProductVoteIdWithUser(Long voteId) {
		//Product findProductVoteIdWithUser = productVoteRepository.findProductVoteIdWithUser(1L);
		return null;
	}

	@Override
	public List<Product> findTop20ByTotalScore() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	/* 상품에서 음악 조회수(readCount), 
	   음악 별점(productStar)의 합산해서 Top 20명 추출 후 
	   voteId 세팅(1번~20번의 값으로)
	   추후--> 투표 기강 설정해서 voteId를 다르게 주는 방법도 고려 필요 
 		<< 작동 완료 >>
 	*/
	
	/*
	@Override
	public List<Product> findTop20ByTotalScore(){
		List<Product> productListTop20ByTotalScore 
		= productRepository.findTop20ByTotalScore();
		
		// product Top 20개 추출
	    if (productListTop20ByTotalScore.size() > 20) {
	        productListTop20ByTotalScore = productListTop20ByTotalScore.subList(0, 20);
	    }
	    // product Top 20에 의 사이즈에 맞는 voteId를 설정
	    for (int i = 0; i < productListTop20ByTotalScore.size(); i++) {
	        Product product = productListTop20ByTotalScore.get(i);
	       
	        Vote vote;
	        
			try {
				vote = voteServiceImpl.selectByVoteNo((long) (i));
				product.setVote(vote);
			} catch (Exception e) {
				e.printStackTrace();
			}
			productServiceImpl.updateProduct(product);
	    }
	    
		return productListTop20ByTotalScore;
	}
	*/
}