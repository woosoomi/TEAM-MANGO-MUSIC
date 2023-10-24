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
values (10000, 1, SYSTIMESTAMP, 1, '결제완료', '팀장님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (20000, 2, SYSTIMESTAMP, 2, '배송준비중', '경진님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (30000, 3, SYSTIMESTAMP, 3, '배송중', '승규님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (40000, 4, SYSTIMESTAMP, 4, '배송완료', '예린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (50000, 5, SYSTIMESTAMP, 5, '결제완료', '수미님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (60000, 6, SYSTIMESTAMP, 6, '배송준비중', '광훈님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (70000, 7, SYSTIMESTAMP, 7, '배송중', '채린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (80000, 8, SYSTIMESTAMP, 8, '배송완료', '범석님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (50000, 1, SYSTIMESTAMP, 9, '배송중', '팀장님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (40000, 2, SYSTIMESTAMP, 10, '결제완료', '경진님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (30000, 3, SYSTIMESTAMP, 11, '배송중', '승규님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (20000, 4, SYSTIMESTAMP, 12, '배송중', '예린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (10000, 5, SYSTIMESTAMP, 13, '배송완료', '수미님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (70000, 6, SYSTIMESTAMP, 14, '배송준비중', '광훈님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (60000, 7, SYSTIMESTAMP, 15, '배송중', '채린님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (80000, 8, SYSTIMESTAMP, 16, '배송완료', '범석님');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (3, order_item_no_seq.nextval, 1, 1);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (5, order_item_no_seq.nextval, 1, 2);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (6, order_item_no_seq.nextval, 3, 3);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (3, order_item_no_seq.nextval, 4, 4);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (8, order_item_no_seq.nextval, 4, 5);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (9, order_item_no_seq.nextval, 6, 6);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (10, order_item_no_seq.nextval, 7, 7);
INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (2, order_item_no_seq.nextval, 8, 8);

INSERT INTO COUPON (COUPON_DISCOUNT, COUPON_EXPIRATION_DATE, COUPON_IS_USED, COUPON_ID, CREATED_AT, ORDER_ID, UPDATED_AT, COUPON_CODE, COUPON_NAME, COUPON_TYPE, USER_ID) 
values (10, TO_DATE('2023-10-30', 'YYYY-MM-DD'), 0, 1, '2023-10-30 00:00:00', 1, '2023-10-24 00:00:00', '00000001', '회원가입 감사쿠폰', '1개월쿠폰', '팀장님');
INSERT INTO COUPON (COUPON_DISCOUNT, COUPON_EXPIRATION_DATE, COUPON_IS_USED, COUPON_ID, CREATED_AT, ORDER_ID, UPDATED_AT, COUPON_CODE, COUPON_NAME, COUPON_TYPE, USER_ID) 
values (20, TO_DATE('2023-10-30', 'YYYY-MM-DD'), 0, 2, '2023-10-30 00:00:00', 1, '2023-10-24 00:00:00', '00000002', '10월 감사제 쿠폰', '1개월쿠폰', '팀장님');

commit;