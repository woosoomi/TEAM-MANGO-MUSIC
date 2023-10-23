package com.itwill.jpa.service.user;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

@SpringBootTest
class UserServiceImplTest extends TeamProjectMangoApplicationTest{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원가입")
    public void testCreateUser() {
        User user = new User();
        user.setUserId("님님님");
        user.setUserPw("9876");
        user.setUserName("테스트님");
        user.setUserPhone("010-1234-5678");

        userRepository.save(user);
        try {
            User createdUser = userService.createUser(user);
            assertNotNull(createdUser);
            assertEquals(">>> 님님님", createdUser.getUserId());
            System.out.println(">>> 회원가입 성공" + createdUser);
        } catch (Exception e) {
            fail(">>> 회원가입 실패 " + e.getMessage());
        }
    }

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원로그인")
    public void testLoginUser() {
		String UserId = "범석님";
        String UserPw = "8888";
        try {
	        User loginUser = userService.loginUser(UserId, UserPw);
	        assertNotNull(loginUser);
	        assertEquals(UserId, loginUser.getUserId());
	        
	        System.out.println(">>> 로그인 성공: " + loginUser);
        }catch (Exception e) {
        	fail(">>> 로그인 실패: " + e.getMessage());
		}
	
	}
	
	@Test
	@Disabled
    @Transactional
    @Rollback(false)
    @DisplayName("회원수정")
    public void testUpdateUser() {
        String userId = "범석님";
        String newUserName = "테스트네임";

        try {
            User user = userService.findUser(userId);
            assertNotNull(user);
            
            user.setUserName(newUserName);
            User updatedUser = userService.updateUser(user);
            
            assertNotNull(updatedUser);
            assertEquals(newUserName, updatedUser.getUserName());
            System.out.println(">>> 회원 수정 성공 " + updatedUser);
        } catch (Exception e) {
            fail(">>> 회원 수정 실패 " + e.getMessage());
        }
    }
	
	@Test
	@Disabled
    @Transactional
    @Rollback(false)
    @DisplayName("회원탈퇴")
    public void testDeleteUser() {
        String userId = "aaaas";

        try {
            userService.deleteUser(userId);
            
        } catch (Exception e) {
            fail(">>> 회원 탈퇴 실패 " + e.getMessage());
        }
    }
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원상세보기")
	public void testFindUser() {
		String userId = "범석님";

		try {
			User user = userService.findUser(userId);
			assertNotNull(user);
			assertEquals(userId, user.getUserId());
			System.out.println(">>> 회원 조회 성공 " + user);
		} catch (Exception e) {
			fail(">>> 회원 조회 실패 " + e.getMessage());
		}
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("전체회원리스트")
	public void testFindUserList() {
		try {
			List<User> userList = userService.findUserList();
			assertNotNull(userList);
			assertFalse(userList.isEmpty());
			System.out.println(">>> 전체 회원 리스트 " + userList);
		} catch (Exception e) {
			fail(">>> 전체회원리스트 조회 실패 " + e.getMessage());
		}
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("아이디중복체크")
	public void testExistsById() throws Exception {
		 String existingUserId = "팀장님";

		    boolean isExists = userService.existsById(existingUserId);
		    if (isExists) {
		        System.out.println(">>> 아이디 중복됨.");
		        assertTrue(isExists);
		    } else {
		        System.out.println(">>> 아이디 중복 안됨.");
		        assertFalse(isExists);
		    }
		}

		@Test
		@Disabled
		@Transactional
		@Rollback(false)
		@DisplayName("이메일로 아이디 찾기")
		public void testFindUserIdByUserEmail() {
			String userEmail = "kbs@gmail.com";

			try {
				String foundUserId = userService.findUserIdByUserEmail(userEmail);
				assertNotNull(foundUserId);
				System.out.println(">>> 아이디 찾기 성공: " + foundUserId);
			} catch (Exception e) {
				fail(">>> 아이디 찾기 실패: " + e.getMessage());
			}
		}

		@Test
		//@Disabled
		@Transactional
		@Rollback(false)
		@DisplayName("번호로 비밀번호 찾기")
		public void testFindUserPwByUserPhone() {
			String userPhone = "010-8888-8888";

			try {
				String foundUserPw = userService.findUserPwByUserPhone(userPhone);
				assertNotNull(foundUserPw);
				System.out.println("비밀번호 찾기 성공: " + foundUserPw);
			} catch (Exception e) {
				fail("비밀번호 찾기 실패: " + e.getMessage());
			}
		}
	}

