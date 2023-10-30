package com.itwill.jpa.service.user;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.repository.user.UserVoteRepository;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.vote.VoteServiceImpl;


class UserVoteServiceImplTest extends TeamProjectMangoApplicationTest{
	@Autowired
	UserVoteRepository userVoteRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired 
	VoteServiceImpl voteServiceImpl;
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Test
    @Transactional
    @Rollback(false)
    @DisplayName("회원수정")
	@Disabled
    public void testUpdateUser() {
		Vote vote1 = Vote.builder()
						 .voteId(1L)
						 .voteTot(320)
						 .build();
		voteServiceImpl.createVote(vote1);
		
		String userId = "ycl77";
		String newUserName = "Vote 테스트";
		String newUserGenger = "Vote";
		String newUserPhone = "010-1111-1111";
		try {
			User user = userDao.findUser(userId);
			assertNotNull(user);

			user.setUserName(newUserName);
			user.setUserGender(newUserGenger);
			user.setUserPhone(newUserPhone);
			user.setVote(vote1);
			User updatedUser = userDao.updateUser(user);

			System.out.println(">>> 회원 수정 성공 " + updatedUser);
		} catch (Exception e) {
			fail(">>> 회원 수정 실패 " + e.getMessage());
		}
		
		userVoteRepository.findUserVoteId(1L);
		System.out.println("@@@@@@@@@@@@@>>>"+userVoteRepository.findUserVoteId(1L));
		
	}
	
	
	@Test
    @Transactional
    @Rollback(false)
	@DisplayName("유저,투표,상품전체조회")
	//@Disabled
    public void testfindUserVoteIdWithProduct() {
    	
    	Vote vote1 = Vote.builder()
				 .voteId(1L)
				 .voteTot(320)
				 .build();
    	voteServiceImpl.createVote(vote1);
    	
    	// User 생성
    	User user = new User();
        user.setUserId("vote");
        user.setUserPw("vote");
        user.setUserName("vote테스트님");
        user.setUserPhone("010-1234-5678");
        user.setVote(vote1);
        userDao.createUser(user);
    	System.out.println("@@@"+user);  
    	
    	// product VoteId 수정
      	Long productNo = 1L;
        Product product = productServiceImpl.getProduct(productNo);
        product.setProductName("수정 테스트완료");
        product.setVote(vote1);

        // updateProduct 메서드 호출
        Product updatedProduct = productServiceImpl.updateProduct(product);
          
        userVoteRepository.findUserVoteIdWithProduct(1L);
          
        // findProductVoteIdWithUser 호출 --> product의 voteId로 User와 Vote 전체 호출
        userVoteRepository.findUserVoteIdWithProduct(1L);
        System.out.println(">>>>> "+userVoteRepository.findUserVoteIdWithProduct(1L));
    
    }
	
}

