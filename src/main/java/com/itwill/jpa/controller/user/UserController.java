package com.itwill.jpa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

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