INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (1, '서울시 관악구', 'CJ대한통운', '박명수', '010-3333-4442', '팀장님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (2, '서울시 성동구', '우체국택배', '유재석', '011-2918-3324', '경진님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (3, '서울시 구로구', '한진택배', '정형돈', '011-3503-3404', '승규님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (4, '서울시 송파구', '롯데택배', '노홍철', '011-6545-5489', '예린님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (5, '서울시 노원구', '로젠택배', '하하', '011-4399-3249', '수미님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (6, '서울시 양천구', '우체국택배', '정준하', '011-2304-3498', '광훈님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (7, '서울시 강동구', 'CJ대한통운', '길', '011-3485-3490', '채린님');

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (8, '서울시 강남구', '로젠택배', '개리', '011-1432-2355', '범석님');


INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (10000, 1, SYSTIMESTAMP, order_order_no_seq.nextval, '결제완료', '팀장님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (20000, 2, SYSTIMESTAMP, order_order_no_seq.nextval, '배송준비중', '경진님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (30000, 3, SYSTIMESTAMP, order_order_no_seq.nextval, '배송중', '승규님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (40000, 4, SYSTIMESTAMP, order_order_no_seq.nextval, '배송완료', '예린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (50000, 5, SYSTIMESTAMP, order_order_no_seq.nextval, '결제완료', '수미님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (60000, 6, SYSTIMESTAMP, order_order_no_seq.nextval, '배송준비중', '광훈님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (70000, 7, SYSTIMESTAMP, order_order_no_seq.nextval, '배송중', '채린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (80000, 8, SYSTIMESTAMP, order_order_no_seq.nextval, '배송완료', '범석님');


commit;