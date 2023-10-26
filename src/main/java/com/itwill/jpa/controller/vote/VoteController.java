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
		String forwardPath = "vote_Main";
		return forwardPath;
	}

	
	
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
		"user_vote_action"
	})
	public String user_get() {
		String forwardPath = "redirect:index";
		return forwardPath;
	}
    
	
}

