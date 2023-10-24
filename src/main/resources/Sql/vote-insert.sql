INSERT INTO vote (product_no, user_id, vote_date, vote_tot, vote_no)
SELECT p.product_no, u.user_id, SYSTIMESTAMP, 20, vote_no_seq.nextval
FROM product p, userinfo u
WHERE p.product_no = 2 AND u.user_id = '채린님';

INSERT INTO vote (product_no, user_id, vote_date, vote_tot, vote_no)
SELECT p.product_no, u.user_id, SYSTIMESTAMP, 30, vote_no_seq.nextval
FROM product p, userinfo u
WHERE p.product_no = 3 AND u.user_id = '팀장님';