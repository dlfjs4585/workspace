-- 왔어울산 테이블
CREATE TABLE WHAT_BOARD (
  BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY
  ,BOARD_TITLE VARCHAR(200) NOT NULL
  ,BOARD_CONTENT VARCHAR(500) NOT NULL
  ,CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP 
);

SELECT * FROM what_board;

-- 이미지에 해당하는 카테고리
CREATE TABLE WHAT_CATEGORY(
	CATE_CODE INT AUTO_INCREMENT PRIMARY KEY
		, CATE_NAME VARCHAR(50) NOT NULL 
		, CATE_DETAIL VARCHAR(50) NOT NULL
);

SELECT * FROM WHAT_CATEGORY;

-- 카테고리에 들어갈 데이터들
INSERT INTO WHAT_CATEGORY VALUES(1, '맛집', '한식');
INSERT INTO WHAT_CATEGORY VALUES(2, '맛집', '중식');
INSERT INTO WHAT_CATEGORY VALUES(3, '맛집', '일식');
INSERT INTO WHAT_CATEGORY VALUES(4, '맛집', '양식');
INSERT INTO WHAT_CATEGORY VALUES(5, '맛집', '아시안');
INSERT INTO WHAT_CATEGORY VALUES(6, '맛집', '기타');
INSERT INTO WHAT_CATEGORY VALUES(7, '카페/디저트', '디저트');
INSERT INTO WHAT_CATEGORY VALUES(8, '카페/디저트', '카페');
INSERT INTO WHAT_CATEGORY VALUES(9, '추천관광지', '볼거리');
INSERT INTO WHAT_CATEGORY VALUES(10, '추천관광지', '즐길거리');

-- 편의시설 테이블
CREATE TABLE ITEM_AMENITIES(
	AMENITIES_CODE INT AUTO_INCREMENT PRIMARY KEY
		, AMENITIES_NAME VARCHAR(30) NOT NULL UNIQUE
);

INSERT INTO ITEM_AMENITIES VALUES(1, '무료주차');
INSERT INTO ITEM_AMENITIES VALUES(2, '와이파이');
INSERT INTO ITEM_AMENITIES VALUES(3, '배달');
INSERT INTO ITEM_AMENITIES VALUES(4, '테이크아웃');

-- 이미지 해당 아이템 정보 테이블
CREATE TABLE WHAT_ITEM(
	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_NAME VARCHAR(50) NOT NULL UNIQUE
	, ITEM_INTRO VARCHAR(100)
	, ITEM_AREA VARCHAR(30) NOT NULL -- 지역
	, CATE_CODE INT NOT NULL REFERENCES WHAT_CATEGORY (CATE_CODE)
);

-- 이미지 등록 테이블
CREATE TABLE WHAT_REGIMG(
	IMG_CODE INT AUTO_INCREMENT PRIMARY KEY
   , ORIGIN_FILE_NAME VARCHAR(100) NOT NULL
   , ATTACHED_FILE_NAME VARCHAR(100) NOT NULL
   , IS_MAIN VARCHAR(5) NOT NULL
   , ITEM_CODE INT NOT NULL REFERENCES WHAT_ITEM (ITEM_CODE) ON DELETE CASCADE
);

-- 아이템과 편의시설을 연결하는 중간 테이블 생성
CREATE TABLE ITEM_AMENITIES_MAPPING (
   ITEM_CODE INT NOT NULL
   , AMENITIES_CODE INT NOT NULL
   , PRIMARY KEY (ITEM_CODE, AMENITIES_CODE)
   , FOREIGN KEY (ITEM_CODE) REFERENCES WHAT_ITEM (ITEM_CODE)
   , FOREIGN KEY (AMENITIES_CODE) REFERENCES ITEM_AMENITIES (AMENITIES_CODE)
);

DROP TABLE WHAT_ITEM;