
package com.itwill.jpa.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Operation(summary = "회원가입")
	@PostMapping("/join")
	public ResponseEntity<?> userCreate(@RequestBody UserDto userDto) {
		   try {
		        if (userService.existsById(userDto.getUserId())) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 아이디입니다.");
		        }

		        UserDto createdUser = new UserDto();
		        createdUser.setUserId(userDto.getUserId());
		        createdUser.setUserPw(userDto.getUserPw());

		        userService.createUser(createdUser);

		        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패: " + e.getMessage());
		    }
		}

	@Operation(summary = "로그인")
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
		 try {
		        User user = userService.findUser(userLoginDto.getUserId());
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

	@Operation(summary = "회원상세보기")
	@GetMapping("/{userId}")
	public ResponseEntity<?> userView(@PathVariable(name = "userId") String userId, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null || !sUserId.equals(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" 권한이 없습니다.");
		}

		User user = userService.findUser(userId);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@Operation(summary = "회원업데이트")
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "userId") String userId, @RequestBody UserUpdateDto userUpdateDto, HttpSession session) {
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null || !sUserId.equals(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		try {
			userService.updateUser(userUpdateDto);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@Operation(summary = "회원탈퇴")
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "userId") String userId, HttpSession session) {
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null || !sUserId.equals(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		try {
			userService.deleteUser(userId);
			session.invalidate();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@Operation(summary = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
