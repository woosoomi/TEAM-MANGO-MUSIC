
package com.itwill.jpa.controller.user;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.exception.user.ExistedUserException;
import com.itwill.jpa.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.models.media.MediaType;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Operation(summary = "회원가입[성공]")
	@PostMapping(value = "/join", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> user_write_action(@RequestBody UserDto userDto) throws Exception {
		try {
	        if (userService.existsById(userDto.getUserId())) {
	            throw new ExistedUserException("이미 존재하는 아이디입니다.");
	        }
	        UserDto createdUser = userService.createUser(userDto);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    } catch (ExistedUserException e) {
	        // 이미 존재하는 사용자 예외 처리
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    } catch (Exception e) {
	        // 기타 예외 처리
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Operation(summary = "로그인[성공]")
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> user_Login_action(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
		try {
			UserDto user = userService.findUser(userLoginDto.getUserId());
			if (user != null && user.getUserPw().equals(userLoginDto.getUserPw())) {
				session.setAttribute("sUserId", userLoginDto.getUserId());
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@LoginCheck
	@Operation(summary = "회원상세보기[성공]")
	@GetMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> user_View(@PathVariable(name = "userId") String userId, HttpSession session) {
		try {
	        UserDto user = userService.findUser(userId);
	        if (user == null) {
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } catch (Exception e) {
	        // 기타 예외 처리
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@Operation(summary = "회원리스트[성공]")
	@GetMapping("/list")
	public ResponseEntity<?> userList() throws Exception {
		try {
	        List<UserDto> users = userService.findUserList();
	        if (users.isEmpty()) {
	            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@LoginCheck
	@Operation(summary = "회원업데이트[성공]")
	@PutMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> updateUser(@PathVariable(name = "userId") String userId, @RequestBody UserUpdateDto userUpdateDto) {
		try {
			UserDto updatedUser = userService.updateUser(userUpdateDto);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// 아이디 중복 체크 API
	@Operation(summary = "아이디중복체크")
	@GetMapping("/{userId}")
	public ResponseEntity<Boolean> checkUserIdExists(@PathVariable String userId) throws Exception {
		boolean exists = userService.existsById(userId);
		return new ResponseEntity<>(exists, HttpStatus.OK);
	}

	// 아이디, 이메일로 아이디 찾기 API
	@GetMapping("/find-id")
	public ResponseEntity<String> findUserIdByUserNameUserEmail(@RequestParam(name = "user_name") String userName,
			@RequestParam(name = "user_email") String userEmail) {
		try {
			String foundUserId = userService.findUserIdByUserNameUserEmail(userName, userEmail);
			return new ResponseEntity<>(foundUserId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// 아이디, 전화번호로 비밀번호 찾기 API
	@GetMapping("/find-pw")
	public ResponseEntity<String> findUserPwByUserIdUserPhone(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "user_phone") String userPhone) {
		try {
			String foundUserPw = userService.findUserPwByUserIdUserPhone(userId, userPhone);
			return new ResponseEntity<>(foundUserPw, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
