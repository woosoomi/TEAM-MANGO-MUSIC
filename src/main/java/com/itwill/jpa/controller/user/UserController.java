package com.itwill.jpa.controller.user;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    // 회원 가입
    @PostMapping("/userJoinForm")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // 가입 오류 시 예외 처리
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

	/*
	 * // 로그인
	 * 
	 * @PostMapping("/로그인") public ResponseEntity<User> loginUser(@RequestParam
	 * String userId, @RequestParam String userPw) { try { User authenticatedUser =
	 * userService.loginUser(userId, userPw); return new
	 * ResponseEntity<>(authenticatedUser, HttpStatus.OK); } catch (Exception e) {
	 * // 로그인 오류 시 예외 처리 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); } }
	 * 
	 * // 회원 정보 수정
	 * 
	 * @PutMapping("/수정") public ResponseEntity<User> updateUser(@RequestBody User
	 * user) { try { User updatedUser = userService.updateUser(user); return new
	 * ResponseEntity<>(updatedUser, HttpStatus.OK); } catch (Exception e) { // 정보
	 * 수정 오류 시 예외 처리 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 * 
	 * // 회원 탈퇴
	 * 
	 * @DeleteMapping("/탈퇴/{userId}") public ResponseEntity<?>
	 * deleteUser(@PathVariable String userId) { try {
	 * userService.deleteUser(userId); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { // 탈퇴 오류 시
	 * 예외 처리 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 * 
	 * // 회원 상세 정보 조회
	 * 
	 * @GetMapping("/상세/{userId}") public ResponseEntity<User>
	 * findUser(@PathVariable String userId) { try { User user =
	 * userService.findUser(userId); return new ResponseEntity<>(user,
	 * HttpStatus.OK); } catch (Exception e) { // 정보 조회 오류 시 예외 처리 return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * // 전체 회원 목록 조회
	 * 
	 * @GetMapping("/목록") public ResponseEntity<List<User>> findUserList() { try {
	 * List<User> userList = userService.findUserList(); return new
	 * ResponseEntity<>(userList, HttpStatus.OK); } catch (Exception e) { // 목록 조회
	 * 오류 시 예외 처리 return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * // 아이디 중복 확인
	 * 
	 * @GetMapping("/중복확인/{userId}") public ResponseEntity<Boolean>
	 * existsById(@PathVariable String userId) throws Exception { boolean exists =
	 * userService.existsById(userId); return new ResponseEntity<>(exists,
	 * HttpStatus.OK); }
	 * 
	 * // 이메일로 아이디 찾기
	 * 
	 * @GetMapping("/이메일아이디") public ResponseEntity<String>
	 * findUserIdByUserEmail(@RequestParam String userEmail) { try { String userId =
	 * userService.findUserIdByUserEmail(userEmail); return new
	 * ResponseEntity<>(userId, HttpStatus.OK); } catch (Exception e) { // 아이디 찾기 오류
	 * 시 예외 처리 return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * // 번호로 비밀번호 찾기
	 * 
	 * @GetMapping("/비밀번호찾기") public ResponseEntity<String>
	 * findUserPwByUserPhone(@RequestParam String userPhone) { try { String userPw =
	 * userService.findUserPwByUserPhone(userPhone); return new
	 * ResponseEntity<>(userPw, HttpStatus.OK); } catch (Exception e) { // 비밀번호 찾기
	 * 오류 시 예외 처리 return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
}