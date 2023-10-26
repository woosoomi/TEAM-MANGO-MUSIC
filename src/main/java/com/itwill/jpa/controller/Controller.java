package com.itwill.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	
    @GetMapping("/event") //main 화면
    public String event() {
    	String forwardPath = "event";
    	return forwardPath;
    }


}
