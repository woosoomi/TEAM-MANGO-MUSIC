
package com.itwill.jpa.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Operation(summary = "회원가입[성공]")
	@PostMapping(value = "/join")
	public ResponseEntity<?> user_write_action(@RequestBody UserDto userDto) throws Exception {
		try {
			if (userService.existsById(userDto.getUserId())) {
				throw new ExistedUserException("이미 존재하는 아이디입니다. >>> user_write_action 레스트 컨트롤러 작동");
			}
			UserDto createdUser = userService.createUser(userDto);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (ExistedUserException e) {
			// 이미 존재하는 사용자 예외 처리
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		/*} catch (Exception e) {
			// 기타 예외 처리
			return new ResponseEntity<>("Internal Server Error>> user_write 레스트 컨트롤러 작동하지만 기타예외로 납치됨", HttpStatus.INTERNAL_SERVER_ERROR); */
		}
	}
	
	@Operation(summary = "로그인[성공]")
	@PostMapping(value = "/login")
	public ResponseEntity<?> user_login_action(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
		try {
			User loginUser = userService.loginUser(userLoginDto.getUserId(), userLoginDto.getUserPw());

			if (loginUser != null) {
				session.setAttribute("sUserId", loginUser.getUserId());
				return ResponseEntity.status(HttpStatus.OK).body("Login successful");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@LoginCheck
	@Operation(summary = "회원상세보기[성공]")
	@GetMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<UserDto> user_View(@PathVariable(name = "userId") String userId, HttpSession session) throws Exception {
		 UserDto userDto = UserDto.builder().build();
		    try {
		        if (session.getAttribute(userId) != null) {
		            UserDto user = userDto.toDto(User.toEntity(userService.findUser(userId)));
		            if (user != null) {
		                userDto.setUserId(user.getUserId());
		                userDto.setUserPw(user.getUserPw());
		                userDto.setUserName(user.getUserName());
		                userDto.setUserAddress(user.getUserAddress());
		                userDto.setUserEmail(user.getUserEmail());
		                userDto.setUserJumin(user.getUserJumin());
		                userDto.setUserPhone(user.getUserPhone());
		                userDto.setUserGender(user.getUserGender());
		                return new ResponseEntity<>(userDto, HttpStatus.OK);
		            } else {
		                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		            }
		        } else {
		            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		        }
		    } catch (Exception e) {
		        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
	public ResponseEntity<Boolean> checkUserIdExists(@PathVariable(name = "userId") String userId) throws Exception {
		boolean exists = userService.existsById(userId);
		return new ResponseEntity<>(exists, HttpStatus.OK);
	}

	// 아이디, 이메일로 아이디 찾기 API
	@Operation(summary = "아이디찾기[성공]")
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
	@Operation(summary = "비밀번호찾기[성공]")
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

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
	    return new ResponseEntity<>("서버 오류: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


}