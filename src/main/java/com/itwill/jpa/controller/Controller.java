package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/userfavoritegrid")
	public String userfavoritegrid() {
		String forwardPath ="userfavoritegrid";
		return forwardPath;
		
	}
	@GetMapping("/index")
	public String index() {
		String forwardPath ="index";
		return forwardPath;
		
	}



	
}


