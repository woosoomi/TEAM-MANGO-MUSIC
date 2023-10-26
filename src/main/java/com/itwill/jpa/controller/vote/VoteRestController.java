package com.itwill.jpa.controller.vote;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.DeliveryService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.vote.VoteService;
import com.itwill.jpa.service.vote.VoteServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/vote")
//@RequiredArgsConstructor
public class VoteRestController {
	
	@Autowired
	private VoteServiceImpl voteServiceImpl;
	
	@Autowired
	private VoteService voteService;
	
	
	//private final VoteService voteService;


	@Operation(summary = "투표생성")
	@PutMapping("/create")
	public ResponseEntity<VoteDto> createVote(@RequestBody VoteDto voteDto) {
	    
		Vote vote = new Vote(null, null, 0, null, null);
		VoteDto.toDto(vote);
		vote.setVoteId(voteDto.getVoteId());
		vote.setVoteDate(voteDto.getVoteDate());
		vote.setVoteTot(voteDto.getVoteTot());
		
	    // 서비스 메서드를 호출하여 투표 생성
	    Vote createdVote = voteServiceImpl.createVote(vote);
	    
	    // 생성된 투표 엔티티를 다시 DTO로 변환
	    VoteDto createdVoteDto = new VoteDto(createdVote);
	    
	    // ResponseEntity에 DTO를 담아 응답
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdVoteDto);
	}
    
	
	@Operation(summary = "투표삭제")
	@DeleteMapping("/{voteId}")
	public ResponseEntity<Map<String, Object>> deleteVote(@PathVariable(name = "voteId") Long voteId) throws Exception {
	    Map<String, Object> responseMap = new HashMap<>();
	    
	    if (voteServiceImpl.selectByVoteNo(voteId) == null) {
	        responseMap.put("message", "없는 투표 번호입니다.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
	    }

	    voteServiceImpl.deleteByVoteNo(voteId);
	    responseMap.put("message", "투표가 삭제되었습니다.");
	    return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	

}
