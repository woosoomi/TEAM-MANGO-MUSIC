INSERT INTO product_category (category_id, product_category_name)
VALUES (1, 'music');

INSERT INTO product_category (category_id, product_category_name)
VALUES (2, 'goods');

INSERT INTO product_category (category_id, product_category_name)
VALUES (3, 'ticket');

INSERT INTO product_category (category_id, product_category_name)
VALUES (4, 'membership');

-- "음악" 카테고리 제품 1
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use)
VALUES (1, '음악 제품 1', 100, 'music', '음악 제품 설명 1', '음악 제품 댓글 1', '4.5', TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, '이미지 URL 1', '뮤직비디오 URL 1', '아티스트 1', 30);

-- "음악" 카테고리 제품 2
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use)
VALUES (2, '음악 제품 2', 150, 'music', '음악 제품 설명 2', '음악 제품 댓글 2', '4.0', TO_DATE('2023-10-24', 'YYYY-MM-DD'), 80, 30, '이미지 URL 2', '뮤직비디오 URL 2', '아티스트 2', 30);

-- "음악" 카테고리 제품 3
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use)
VALUES (3, '음악 제품 3', 120, 'music', '음악 제품 설명 3', '음악 제품 댓글 3', '4.2', TO_DATE('2023-10-25', 'YYYY-MM-DD'), 120, 40, '이미지 URL 3', '뮤직비디오 URL 3', '아티스트 3', 30);

-- "굿즈" 카테고리 제품 1
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, period_of_use)
VALUES (4, '굿즈 제품 1', 50, 'goods', '굿즈 제품 설명 1', '굿즈 제품 댓글 1', '4.7', TO_DATE('2023-10-26', 'YYYY-MM-DD'), 60, 10, '이미지 URL 4', 30);

-- "굿즈" 카테고리 제품 2
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, period_of_use)
VALUES (5, '굿즈 제품 2', 60, 'goods', '굿즈 제품 설명 2', '굿즈 제품 댓글 2', '4.3', TO_DATE('2023-10-27', 'YYYY-MM-DD'), 70, 15, '이미지 URL 5', 30);

-- "굿즈" 카테고리 제품 3
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Image, period_of_use)
VALUES (6, '굿즈 제품 3', 70, 'goods', '굿즈 제품 설명 3', '굿즈 제품 댓글 3', '4.4', TO_DATE('2023-10-28', 'YYYY-MM-DD'), 80, 20, '이미지 URL 6', 30);

-- "티켓" 카테고리 제품 1
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Address, period_of_use)
VALUES (7, '티켓 제품 1', 200, 'ticket', '티켓 제품 설명 1', '티켓 제품 댓글 1', '4.8', TO_DATE('2023-10-29', 'YYYY-MM-DD'), 90, 5, '콘서트 장소 1', 30);

-- "티켓" 카테고리 제품 2
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Address, period_of_use)
VALUES (8, '티켓 제품 2', 250, 'ticket', '티켓 제품 설명 2', '티켓 제품 댓글 2', '4.6', TO_DATE('2023-10-30', 'YYYY-MM-DD'), 110, 8, '콘서트 장소 2', 30);

-- "티켓" 카테고리 제품 3
INSERT INTO product (product_No, product_Name, product_Price, dtype, product_Content, product_Reply, product_Star, product_Date, read_Count, product_Stock, product_Address, period_of_use)
VALUES (9, '티켓 제품 3', 300, 'ticket', '티켓 제품 설명 3', '티켓 제품 댓글 3', '4.9', TO_DATE('2023-10-31', 'YYYY-MM-DD'), 130, 10, '콘서트 장소 3', 30);