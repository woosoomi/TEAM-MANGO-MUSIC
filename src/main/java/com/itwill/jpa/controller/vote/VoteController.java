package com.itwill.jpa.controller.vote;

import org.springframework.web.bind.annotation.GetMapping;

public class VoteController {

	@GetMapping(value = "/vote")
	public String vote_html() {
		return "voteMain";
	}


}
