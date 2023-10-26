package com.itwill.jpa.controller.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VoteController {
	/*
	@Autowired
	private VoteController voteController;
	*/
	
	@GetMapping(value = "/vote")
	public String vote_html() {
		String forwardPath = "vote_Main";
		return forwardPath;
	}

	/*
	@PostMapping(value = "/user_vote_action")
	private String user_vote_action(@ModelAttribute 
									User user,
									HttpServletRequest request) {
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		Vote sVoteId= (Vote)request.getSession().getAttribute("sVoteId");
		

		String forwardPath = "vote_Main";
		return forwardPath;
	}
	
	
	*/
	
}

