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

}

