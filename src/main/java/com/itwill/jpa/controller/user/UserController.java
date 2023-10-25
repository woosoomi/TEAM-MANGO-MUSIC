package com.itwill.jpa.controller.user;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/index")
    public String main() {
    	String forwardPath = "index";
    	return forwardPath;
    }
    
    
    
    
    
    
    
    
    
    
    
}