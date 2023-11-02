INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (1, '2023-10-22', 1);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (2, '2023-10-23', 10);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (3, '2023-10-24', 20);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (4, '2023-10-24', 30);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (5, '2023-10-25', 40);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (6, '2023-10-26', 50);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (7, '2023-10-27', 60);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (8, '2023-10-28', 70);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (9, '2023-10-29', 80);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (10,'2023-10-30', 90);

/*


INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, s, 10);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-24', 20);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, sysdate, 30);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-25', 40);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-26', 50);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-27', 60);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-28', 70);
INSERT INTO vote (vote_id, vote_date, vote_tot) VALUES (vote_no_seq.NEXTVAL, '2023-10-29', 80);
*/



-- "Vote 에 필요한 기본데이터 10개"  -->>> 추후 삭제 예정 ---
INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'Do or Die', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/009/94/944/994944_20231006163709_500.jpg', '뮤직비디오 URL 1', '임영웅', 30,1);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'Chasing That Feeling ', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/026/32/253/2632253_20231013103136_500.jpg', '뮤직비디오 URL 1', '투모로우바이투게더', 30,1);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'Baddie', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/030/55/146/3055146_20231013113531_500.jpg', '뮤직비디오 URL 1', 'IVE (아이브)', 30,3);


INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'GODS', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/031/14/174/3114174_20230707095732_500.jpg', '뮤직비디오 URL 1', 'NewJeans', 30,4);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'SOLO', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/009/95/173/995173_20231005174025_500.jpg', '뮤직비디오 URL 1', '제니 (JENNIE)', 30,5);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, '뭐 어떡할까', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/005/85/492/585492_20231013163742_500.jpg', '뮤직비디오 URL 1', '기리보이', 30,6);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, '사랑하는 법을 몰라서', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/002/26/490/226490_20230907133634_500.jpg', '뮤직비디오 URL 1', '
FTISLAND', 30,7);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, 'Perfect Night', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/030/92/950/3092950_20231027105934_500.jpg', '뮤직비디오 URL 1', 'LE SSERAFIM (르세라핌)', 30,8);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, '음악의 신', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/008/61/436/861436_20231023135036_500.jpg', '뮤직비디오 URL 1', '세븐틴 (SEVENTEEN)', 30,9);

INSERT INTO product (product_No, product_category_id, product_Name, product_Price, dtype, product_Content, product_Star, product_Date, read_Count, product_Stock, product_Image, product_Movie, product_Artist, period_of_use,vote_id)
VALUES               (product_product_no_seq.nextval, 1, '3D (feat. Jack Harlow)', 100, 'music', '음악 제품 설명 1', 200 , TO_DATE('2023-10-23', 'YYYY-MM-DD'), 100, 50, 'https://cdnimg.melon.co.kr/cm2/artistcrop/images/007/25/987/725987_20230927151422_500.jpg', '뮤직비디오 URL 1', '정국', 30,10);

-- "Vote 에 필요한 기본데이터 10개" 종료 -->>> 추후 삭제 예정---

