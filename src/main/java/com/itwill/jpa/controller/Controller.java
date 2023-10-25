package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	/*
	@GetMapping("/index")
	public String index() {
		String forwardPath = "index";
		return forwardPath;
	}
	*/

	@GetMapping("/userprofile")
	public String userprofile() {
		String forwardPath = "userprofile";
		return forwardPath;

	}

	@GetMapping("/userJoinForm")
	public String userJoinForm() {
		String forwardPath = "userJoinForm";
		return forwardPath;

	}

	@GetMapping("/userCheckId")
	public String userCheckId() {
		String forwardPath = "userCheckId";
		return forwardPath;

	}

	@GetMapping("/userCheckPw")
	public String userCheckPw() {
		String forwardPath = "userCheckPw";
		return forwardPath;

	}

}
