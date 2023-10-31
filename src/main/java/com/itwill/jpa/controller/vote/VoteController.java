package com.itwill.jpa.controller.vote;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.Context;

import com.itwill.jpa.dto.vote.VoteDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class VoteController {
	/*
	@GetMapping(value = "/voteMain")
	public String vote_html() {
		return "voteMain";
	}
	*/
	
	
	@GetMapping(value = "/voteMain")
	public String voteMain(Model model) {
		
		
		return "voteMain";
	}
		
}
