package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	@GetMapping("/userprofile")
	public String userprofile() {
		String forwardPath = "userprofile";
		return forwardPath;
	}

	@GetMapping("/index") 
	public String index() { 
		String forward_path = "index"; 
		return forward_path; 
		}
	
}
