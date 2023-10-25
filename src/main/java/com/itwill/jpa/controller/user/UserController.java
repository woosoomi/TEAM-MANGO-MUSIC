package com.itwill.jpa.controller.user;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/index")
    public String main() {
    	String forwardPath = "index";
    	return forwardPath;
    }
    
    @RequestMapping("/userJoinForm")
	public String userJoinForm() {
		String forward_path = "userJoinForm";
		return forward_path;
	}
    
    @RequestMapping("/userCheckIdPw")
	public String userCheckIdPw() {
		String forward_path = "userCheckIdPw";
		return forward_path;
	}
    
    @PostMapping("user_write_action")
	public String user_write_action(@ModelAttribute("fuser") User user, Model model) throws Exception {
		String forward_path = "";
		try {
			User rowCount = userService.createUser(user);
			forward_path="redirect:user_login_form";
		}catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("fuser", user);
			forward_path="user_write_form";
		}
		return forward_path;
	}
    
    @RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
    
    
    
    
    
    
    
    
    
    
}