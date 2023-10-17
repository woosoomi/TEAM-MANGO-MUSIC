package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class Controller {
	
	@GetMapping("/index")
	public String index() {
		String forwardPath ="index";
		return forwardPath;
		
	}



	
}


