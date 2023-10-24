INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('팀장님', '1111', '우한영', '서울시 강남', 'why@gmail.com', '111111-1111111', '010-1111-1111', '남');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('경진님', '2222', '차경진', '수원시 ', 'cgj@gmail.com', '222222-2222222', '010-2222-2222', '남');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('승규님', '3333', '이승규', '인천', 'lsg@gmail.com', '333333-3333333', '010-3333-3333', '남');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('예린님', '4444', '문예린', '송파', 'myl@gmail.com', '444444-4444444', '010-4444-4444', '여');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('수미님', '5555', '우수미', '남양주', 'wsm@gmail.com', '555555-5555555', '010-5555-5555', '여');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('광훈님', '6666', '류광훈', '성남', 'rgh@gmail.com', '666666-6666666', '010-6666-6666', '남');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('채린님', '7777', '유채린', '구리', 'ycl@gmail.com', '777777-7777777', '010-7777-7777', '여');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('범석님', '8888', '고범석', '충남', 'kbs@gmail.com', '888888-8888888', '010-8888-8888', '남');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('aaa', '9999', '에이', '에이군', 'a@gmail.com', 'aaaaaa-aaaaaaa', '010-aaaa-aaaa', 'A');
INSERT INTO userinfo(USER_ID, USER_PW, USER_NAME, USER_ADDRESS, USER_EMAIL, USER_JUMIN, USER_PHONE, USER_GENDER) 
VALUES('bbb', '1234', '비', '비군', 'b@gmail.com', 'bbbbbb-bbbbbbb', '010-bbbb-bbbb', 'B');

INSERT INTO user_board (user_board_id, board_id, user_id)
VALUES (USER_BOARD_NO_SEQ.nextval, 1, '팀장님');
INSERT INTO user_board (user_board_id, board_id, user_id)
VALUES (USER_BOARD_NO_SEQ.nextval, 2, '승규님');


commit;