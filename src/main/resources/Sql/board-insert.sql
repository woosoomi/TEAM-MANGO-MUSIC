INSERT INTO board_category (board_category_id, board_category_name)
VALUES (1, '공지사항');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (2, '이벤트');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (3, '매거진');

INSERT INTO board_category (board_category_id, board_category_name)
VALUES (4, '1대1문의');

INSERT INTO board_type(board_type_id,board_type_title)
VALUES(1,'기타');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(2,'일반공지');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(3,'서비스공지');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(4,'시스템공지');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(5,'회원정보');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(6,'결제/환불');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(7,'이벤트');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(8,'답변완료');
INSERT INTO board_type(board_type_id,board_type_title)
VALUES(9,'답변대기중');


INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 1,  SYSTIMESTAMP, SYSTIMESTAMP, '공지사항테스트내용1', '공지사항테스트이미지1', '공지사항테스트타이틀1');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 1,  SYSTIMESTAMP, SYSTIMESTAMP, '공지사항테스트내용2', '공지사항테스트이미지2', '공지사항테스트타이틀2');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 2,  SYSTIMESTAMP, SYSTIMESTAMP, '이벤트테스트내용1', '이벤트테스트이미지1', '이벤트테스트타이틀1');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 2,  SYSTIMESTAMP, SYSTIMESTAMP, '이벤트테스트내용2', '이벤트테스트이미지2', '이벤트테스트타이틀2');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 3,  SYSTIMESTAMP, SYSTIMESTAMP, '매거진테스트내용1', '매거진테스트이미지1', '매거진테스트타이틀1');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 3,  SYSTIMESTAMP, SYSTIMESTAMP, '매거진테스트내용2', '매거진테스트이미지2', '매거진테스트타이틀2');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 4,  SYSTIMESTAMP, SYSTIMESTAMP, '문의테스트내용1', '문의테스트이미지1', '문의테스트타이틀1');

INSERT INTO BOARD (board_id, board_category_id, created_time, update_time, board_content, board_image, board_title)
VALUES (board_board_no_seq.nextval, 4,  SYSTIMESTAMP, SYSTIMESTAMP, '문의테스트내용2', '문의테스트이미지2', '문의테스트타이틀2');


commit;