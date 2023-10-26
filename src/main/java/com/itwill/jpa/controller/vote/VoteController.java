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
import org.springframework.web.bind.annotation.RequestBody;

import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.service.vote.VoteServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class VoteController {
	/*
	 * @Autowired private VoteController voteController;
	 */
	@Autowired
	VoteServiceImpl voteServiceImpl;

	@GetMapping(value = "/vote")
	public String vote_html() {
		return "voteMain";
	}


	/*
	@Operation(summary = "투표생성")
	@GetMapping
	public ResponseEntity<Response> createVote(@RequestBody Vote vote) {
	    try {
	        // 투표 생성 서비스를 호출하여 새로운 투표를 생성
	        Vote createdVote = voteServiceImpl.createVote(vote);
	        
	        // 투표가 성공적으로 생성된 경우, HTTP 상태 코드 201(Created)와 생성된 투표를 반환
	        Response response = new Response();
	        response.setStatus(ResponseStatusCode.CREATED_VOTE);
	        response.setData(createdVote);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // 투표 생성 중에 오류가 발생한 경우, 오류 응답을 반환
	        Response errorResponse = new Response();
	        errorResponse.setStatus(ResponseStatusCode.ERROR);
	        errorResponse.setMessage("투표 생성 중 오류 발생: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
    */
	
	
	@DeleteMapping("/{voteId}")
	public ResponseEntity<Map> deleteVote(@PathVariable(name="voteID") Long voteId) throws Exception{
		if (voteServiceImpl.selectByVoteNo(voteId)==null) {
			Response response = new Response();
			response.setMessage("없는 투표 번호입니다.");
		}
		
		voteServiceImpl.deleteByVoteNo(voteId);
		
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}
	
	

}
