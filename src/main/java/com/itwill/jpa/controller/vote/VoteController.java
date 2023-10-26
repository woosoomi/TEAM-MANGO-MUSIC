 package com.itwill.jpa.controller.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoteController {
	/*
	@Autowired
	private VoteController voteController;
	*/
	@GetMapping(value = "/vote")
	public String vote_html() {
		return "voteMain";
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

