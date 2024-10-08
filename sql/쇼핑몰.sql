
-- 쇼핑몰 프로젝트 테이블 정의
-- 테이블 종류 ---
-- 1. 회원 정보 테이블
-- 2. 상품 카테고리 테이블
-- 3. 상품 정보 테이블
-- 4. 상품 이미지 정보 테이블
-- 5. 장바구니 정보 테이블
-- 6. 구매 정보 테이블

-- 1. 회원 정보 테이블
-- 권한 : USER, ADMIN
CREATE TABLE SHOP_MEMBER (
	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(100) NOT NULL
	, MEM_NAME VARCHAR(50) NOT NULL
	, MEM_TEL VARCHAR(30) UNIQUE
	, POST VARCHAR(10)
	, MEM_ADDR VARCHAR(50)
	, ADDR_DETAIL VARCHAR(100)
	, MEM_EMAIL VARCHAR(100)
	, MEM_ROLE VARCHAR(30) DEFAULT 'USER'
);

-- 2.상품 카테고리(소설, 에세이, 인터넷/IT)
CREATE TABLE ITEM_CATEGORY (
	CATE_CODE INT AUTO_INCREMENT PRIMARY KEY
	, CATE_NAME VARCHAR(50) NOT NULL UNIQUE
);

-- 카테고리 데이터
INSERT INTO item_category VALUES(1, '인터넷/IT');
INSERT INTO item_category VALUES(2, '소설/에세이');
INSERT INTO item_category VALUES(3, '자기개발');

-- 3. 상품 정보 테이블
-- ITEM_STATUS(상품 상태) : (FOR_SALE)판매중, SOLD_OUT(매진)
CREATE TABLE SHOP_ITEM (
	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_NAME VARCHAR(50) NOT NULL UNIQUE
	, ITEM_PRICE INT NOT NULL
	, ITEM_INTRO VARCHAR(100)
	, ITEM_STOCK INT DEFAULT 20
	, ITEM_STATUS VARCHAR(10) DEFAULT 'FOR_SALE'
	, CATE_CODE INT NOT NULL REFERENCES ITEM_CATEGORY (CATE_CODE)
);

-- 4. 상품 이미지 정보 테이블
-- ORIGIN_FILE_NAME : 원본 파일명
-- ATTACHED_FILE_NAME : 첨부된 파일명
-- IS_MAIN : 대표 이미지 여부 (Y, N)
CREATE TABLE ITEM_IMG (
	IMG_CODE INT AUTO_INCREMENT PRIMARY KEY
	,	ORIGIN_FILE_NAME VARCHAR(100) NOT NULL
	,	ATTACHED_FILE_NAME VARCHAR(100) NOT NULL
	,	IS_MAIN VARCHAR(5) NOT NULL
	,	ITEM_CODE INT REFERENCES shop_item (ITEM_CODE) ON DELETE CASCADE
);

INSERT INTO ITEM_IMG(ORIGIN_FILE_NAME, ATTACHED_FILE_NAME, IS_MAIN, ITEM_CODE) 
VALUES ('abc.jpg', 'aaa.jpg', 'Y', 1),
VALUES ('asd.jpg', 'bbb.jpg', 'N', 1);

SELECT * FROM ITEM_IMG;

-- 5. 장바구니 정보 테이블
CREATE TABLE SHOP_CART (
	CART_CODE INT AUTO_INCREMENT PRIMARY KEY
	, CART_CNT INT NOT NULL
	, ITEM_CODE INT NOT NULL REFERENCES shop_item (ITEM_CODE)
	, MEM_ID VARCHAR(50) NOT NULL REFERENCES shop_member (MEM_ID)
	, CART_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM shop_cart;

DELETE FROM shop_cart;

SELECT * FROM shop_member;
DELETE FROM SHOP_ITEM
WHERE ITEM_NAME = 'asdasddddd';
SELECT * FROM ;

SELECT * FROM SHOP_ITEM;
DROP TABLE shop_member;

SELECT MEM_ID
FROM shop_member
WHERE MEM_ID = 'java';

INSERT INTO shop_member(
	MEM_ID
	, MEM_PW
	, MEM_NAME
	, MEM_TEL
	, POST
	, MEM_ADDR
	, ADDR_DETAIL
	, MEM_EMAIL
	, MEM_ROLE
) VALUES(
	'admin'
	, 'asd123'
	, '관리자'
	, '010-1234-1233'
	, '우편번호'
	, '주소'
	, '상세주소'
	, '관리자@gmail.com'
	, 'ADMIN'
);

SELECT * FROM shop_item;
SELECT * FROM item_img;
DELETE FROM shop_item;

DELETE FROM shop_cart
WHERE CART_CODE = 23;


CREATE TABLE test_SHOP_item(
	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_NAME VARCHAR(50)
);

INSERT INTO TEST_SHOP_ITEM(ITEM_NAME) VALUES('AAA');
INSERT INTO TEST_SHOP_ITEM(ITEM_CODE, ITEM_NAME) VALUES(2, 'AAA');

SELECT * FROM TEST_SHOP_ITEM;

DELETE FROM TEST_SHOP_ITEM;

-- NULL : 어떤 값이 들어갈지 정해지지 않았다.
-- 다음에 INSERT 할때 들어갈 ITEM_CODE 조회
-- 데이터가 하나도 없다면 1을 조회
SELECT IFNULL(MAX(ITEM_CODE), 0)+1 FROM TEST_SHOP_ITEM;

-- 장바구니에 같은 상품이 있는지 확인하는 쿼리
SELECT CART_CODE
FROM shop_cart
WHERE ITEM_CODE = #{itemCode}
AND MEM_ID = #{memId}

-- 장바구니에 같은 상품이 있다면, 업데이트 하는 쿼리
UPDATE shop_cart
SET CART_CNT += #{cartCnt}
	, CART_DATE = NOW()	
WHERE MEM_ID = #{memId}
AND ITEM_CODE = #{itemCode}

