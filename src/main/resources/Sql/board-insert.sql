INSERT INTO board_category (board_category_id,board_category_name)
VALUES (1, '공지사항');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (2, '이벤트');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (3, '매거진');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (4, '1대1문의');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (5, 'FAQ');

INSERT INTO board_type(type_id,board_type_title)
VALUES(1,'기타');     //공지사항 and FAQ
INSERT INTO board_type(type_id,board_type_title)
VALUES(2,'일반공지'); //공지사항
INSERT INTO board_type(type_id,board_type_title)
VALUES(3,'서비스공지');   //공지사항
INSERT INTO board_type(type_id,board_type_title)
VALUES(4,'시스템공지');   //공지사항
INSERT INTO board_type(type_id,board_type_title)
VALUES(5,'회원정보');   //FAQ
INSERT INTO board_type(type_id,board_type_title)
VALUES(6,'결제/환불');   //FAQ
INSERT INTO board_type(type_id,board_type_title)
VALUES(7,'이벤트');   //FAQ
INSERT INTO board_type(type_id,board_type_title)
VALUES(8,'답변완료');   //문의
INSERT INTO board_type(type_id,board_type_title)
VALUES(9,'답변대기중');  //문의
INSERT INTO board_type(type_id,board_type_title)
VALUES(10,'진행중이벤트');  //문의
INSERT INTO board_type(type_id,board_type_title)
VALUES(11,'종료된이벤트');  //문의

////////////여기까지 변경사항없는 테이블정보/////////////////

commit;

INSERT INTO BOARD (board_id,
                                    board_category_id,
                                    board_type_id,
                                    BOARD_READ_COUNT,
                                    created_time, update_time, 
                                    board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 
                1,   
                2,    
                999, 
                SYSTIMESTAMP, SYSTIMESTAMP, 
                '공지사항테스트내용1', '공지사항테스트이미지1', '공지사항테스트타이틀1');
                

INSERT INTO BOARD_REPLY(board_reply_id,
                                                board_id,
                                                user_id,
                                                board_reply_title,board_reply_content)
VALUES(board_reply_no_seq.nextval,
              1,
              'why3795',
              '댓글타이틀테스트1','댓글내용테스트');
              
commit;