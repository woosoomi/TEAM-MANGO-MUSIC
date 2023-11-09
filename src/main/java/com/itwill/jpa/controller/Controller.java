package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	@GetMapping("/index") 
	public String index() { 
		String forward_path = "index"; 
		return forward_path; 
	}
	@GetMapping("/userprofile")
	public String userprofile() {
		String forwardPath = "userprofile";
		return forwardPath;
	}
	@GetMapping("/test") 
	public String test() { 
		String forward_path = "test"; 
		return forward_path; 
	}
	@GetMapping("/common") 
	public String common() { 
		String forward_path = "common"; 
		return forward_path; 
	}
	/*
	@GetMapping("/admin") 
	public String admin() { 
		String forward_path = "admin_form"; 
		return forward_path; 
	}
	*/
	
	@GetMapping("/admin_Board") 
	public String admin_Board() { 
		String forward_path = "admin_board_form"; 
		return forward_path; 
	}
	
	@GetMapping("/admin_music") 
	public String admin_Product_music() { 
		String forward_path = "admin_product_music_form"; 
		return forward_path; 
	}
	
	@GetMapping("/admin_goods") 
	public String admin_Product_goods() { 
		String forward_path = "admin_product_goods_form"; 
		return forward_path; 
	}
	
	@GetMapping("/admin_ticket") 
	public String admin_Product_ticket() { 
		String forward_path = "admin_product_ticket_form"; 
		return forward_path; 
	}
	
		
	
}