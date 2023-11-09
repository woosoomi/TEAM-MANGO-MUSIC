
package com.itwill.jpa.controller.user;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.exception.user.PasswordMismatchException;
import com.itwill.jpa.exception.user.UserNotFoundException;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/user_info_form") public String user_info_form() { String
	 * forward_path = "user_info_form"; return forward_path; }
	 */

	/*
	 * @GetMapping("/user_modify_form") public String user_modify_form() { String
	 * forward_path = "user_modify_form"; return forward_path; }
	 */

	@GetMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}

	@GetMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}

	@GetMapping("/user_CheckIdPw")
	public String user_CheckIdPw() {
		String forward_path = "user_CheckIdPw";
		return forward_path;
	}

	@LoginCheck
	@GetMapping("/user_info_form")
	public String user_info_form(HttpSession session, Model model) throws Exception {
		String loginUser = (String) session.getAttribute("sUserId");
		UserDto user = userService.findUser(loginUser);
		model.addAttribute("loginUser", user);
		return "user_info_form";
	}

	@LoginCheck
	@GetMapping("/user_logout_action")
	public String user_logout_action(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}

	@LoginCheck
	@GetMapping("/user_modify_form")
	public String user_modify_form(HttpSession session, Model model) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		UserDto loginUser = userService.findUser(sUserId);
		model.addAttribute("loginUser", loginUser);
		return "user_modify_form";
	}
	
	
	@GetMapping("/admin")
	public String userList(Model model) throws Exception {
	    List<UserDto> userInfoList = userService.findUserList();
	    model.addAttribute("userInfoList", userInfoList);
	    return "admin_form"; // 
	}
	
	

	/*
	 * @LoginCheck
	 * 
	 * @PostMapping("/user_modify_action") public String
	 * user_modify_action(@ModelAttribute UserUpdateDto userUpdateDto,
	 * HttpServletRequest request) throws Exception { String sUserId = (String)
	 * request.getSession().getAttribute("sUserId");
	 * userUpdateDto.setUserId(sUserId); userService.updateUser(userUpdateDto);
	 * return "redirect:user_info_form"; }
	 */
	 
	@LoginCheck
	@PostMapping("/user_remove_action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		String sUserId = (String) request.getSession().getAttribute("sUserId");
		userService.deleteUser(sUserId);
		request.getSession().invalidate();
		return "redirect:index";
	}

	/*********** GET방식요청시 guest_main redirection *********/
	@GetMapping({ "/user_write_action", "/user_login_action", "/user_modify_action", "/user_remove_action" })
	public String user_get() {
		String forwardPath = "redirect:index";
		return forwardPath;
	}

}
