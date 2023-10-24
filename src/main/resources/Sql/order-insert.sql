INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (10000, 1, SYSTIMESTAMP, order_order_no_seq.nextval, '결제완료', '팀장님');

INSERT INTO ORDERS (order_price, delivery_id, order_date, order_id, order_status, user_id) 
values (20000, 2, SYSTIMESTAMP, order_order_no_seq.nextval, '결제완료', '경진님');
commit;