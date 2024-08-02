
-- 데이터베이스의 키(KEY) 종류
-- KEY : 데이터베이스에서 각 행을 구분하는 식별자를 의미
-- 슈퍼키(SUPER KEY) :  하나의 행을 식별할 수 있는 하나 이상의 컬럼
-- 후보키(CAMDIDATE KEY) : 기본키가 될 수 있는 후보
-- 기본키(PRIMARY KEY, PK) : 후보키 중에 각 행을 구분짓기 위해 결정한 키
-- 대체키(ALTERNATE KEY) : 후보키 중에서 기본키를 제외한 키
-- 외래키(FOREIGN KEY, FK) : 다른 테이블의 기본키로 사용되는 키


-- 로그인, 게시글, 댓글 관련 기능 포함 게시판 프로젝트
-- 테이블 : 회원정보, 게시글 정보, 댓글 정보

-- 회원정보 테이블
-- USER : 일반회원
-- ADMIN : 관리자
CREATE TABLE BOARD_MEMBER(
	MEM_ID VARCHAR(50) PRIMARY KEY
	, MEM_PW VARCHAR(50) NOT NULL
	, MEM_NAME VARCHAR(50) NOT NULL
	, GENDER VARCHAR(10) -- 'male', 'female'
	, MEM_ROLE VARCHAR(20) DEFAULT 'USER'
);

-- 임시 회원 데이터
INSERT INTO BOARD_MEMBER (
	MEM_ID
		, MEM_PW
		, MEM_NAME
		, GENDER
		, MEM_ROLE
) VALUES (
	'java'
	, '1111'
	, '김자바'
	, 'male'
	, 'USER'
);

INSERT INTO BOARD_MEMBER (
	MEM_ID
		, MEM_PW
		, MEM_NAME
		, GENDER
		, MEM_ROLE
) VALUES (
	'admin'
	, '1111'
	, '관리자'
	, 'female'
	, 'ADMIN'
);

SELECT * FROM board_member;


-- DELETE FROM board
-- WHERE TITLE = '제에에목';


-- 게시판 정보 테이블(회원만 게시글 작성 가능)
CREATE TABLE BOARD(
	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY
	, TITLE VARCHAR(50) NOT NULL
	, CONTENT VARCHAR(100)
	, MEM_ID VARCHAR(50) REFERENCES BOARD_MEMBER(MEM_ID) -- 작성자, 외래키 
	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 게시글 임시 데이터
INSERT INTO board(TITLE, CONTENT, MEM_ID) 
VALUES ('1번 글', '1번 내용', 'java');
INSERT INTO board(TITLE, CONTENT, MEM_ID) 
VALUES ('2번 글', '2번 내용', 'java');
INSERT INTO board(TITLE, CONTENT, MEM_ID) 
VALUES ('3번 글', '3번 내용', 'admin');

SELECT * FROM BOARD;

-- 댓글 정보 테이블(회원만 가능)
CREATE TABLE BOARD_REPLY(
	REPLY_NUM INT AUTO_INCREMENT PRIMARY KEY
	, REPLY_CONTENT VARCHAR(50) NOT NULL
	, REPLY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
	, MEM_ID VARCHAR(50) REFERENCES BOARD_MEMBER (MEM_ID)
	, BOARD_NUM INT REFERENCES BOARD (BOARD_NUM) -- 게시판 글 번호
);

INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글1', 'java', 1);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글2', 'java', 3);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글3', 'java', 3);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글4', 'admin', 1);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글입력', 'admin', 6);


SELECT * FROM BOARD_MEMBER;
SELECT * FROM BOARD;
SELECT * FROM board_reply;


-- 데이터 조회 연습
-- 회원의 이름이 '김자바'인 회원이 작성한 게시글의 
-- 글번호, 제목, 작성자 아이디, 작성자 이름 조회, 작성일 기준 최신글부터 조회 (내림차순)

SELECT BOARD_NUM, TITLE, BOARD.MEM_ID, MEM_NAME
FROM board_member, board
WHERE BOARD_MEMBER.MEM_ID = board.MEM_ID
AND BOARD_MEMBER.MEM_NAME = '김자바'
ORDER BY CREATE_DATE DESC;

--  모든 게시글의  글 번호, 글 제목, 작성자 및  해당 글에  작성된 
-- 댓글의 댓글 내용, 댓글 작성자, 댓글 작성일을 조회
-- 게시글 번호 기준 최신순으로 정렬 후, 같은 게시글에 대한 댓글은 가장 최근에 달린 댓글 순으로 조회

SELECT BOARD.BOARD_NUM, TITLE, BOARD.MEM_ID, REPLY_CONTENT, board_reply.MEM_ID, REPLY_DATE
FROM board, board_reply
WHERE board.BOARD_NUM = board_reply.BOARD_NUM
ORDER BY BOARD.BOARD_NUM DESC, REPLY_NUM DESC;


SELECT TITLE, CONTENT, CREATE_DATE, REPLY_DATE, BOARD.MEM_ID, REPLY_CONTENT, board_reply.MEM_ID
FROM board, board_reply
WHERE board.BOARD_NUM = board_reply.BOARD_NUM
AND board.BOARD_NUM = 1;

-- 아이디가 'java'인 회원이 작성한 게시글의
-- 글제목, 내용, 작성자Id, 작성자명, 작성자 권한 조회
SELECT TITLE, CONTENT, b.MEM_ID, MEM_NAME, MEM_ROLE
FROM board_member m, board b
WHERE m.MEM_ID = b.MEM_ID
AND b.MEM_ID = 'java1';


-- 글번호가 5번 이하인 게시글의
-- 글번호, 제목, 글 작성자를 조회하되
-- 글번호 기준 오름차순으로 정렬

SELECT BOARD_NUM, TITLE, MEM_NAME
FROM board_member M, board B
WHERE M.MEM_ID = B.MEM_ID
AND BOARD_NUM <= 5
ORDER BY BOARD_NUM ;


-- 1번 게시글의 게시글 제목, 작성자 id 및 
-- 1번 게시글에 작성된 댓글내용, 댓글 작성자 id를 조회

SELECT TITLE, b.MEM_ID, REPLY_CONTENT, r.MEM_ID
FROM board b, board_reply r 
WHERE b.BOARD_NUM = r.BOARD_NUM
AND b.BOARD_NUM = 1;

-- 1번 게시글의 게시글 제목, 작성자 id 및 
-- 1번 게시글에 작성된 댓글내용, 댓글 작성자 id, 댓글 작성자 이름를 조회


SELECT TITLE, b.MEM_ID, REPLY_CONTENT, r.MEM_ID, MEM_NAME
FROM board b, board_reply r, board_member m
WHERE b.BOARD_NUM = r.BOARD_NUM
AND m.MEM_ID = r.MEM_ID
AND b.BOARD_NUM = 1;


SELECT TITLE, BOARD.MEM_ID, MEM_NAME, MEM_ROLE, BOARD_NUM
FROM BOARD_MEMBER, BOARD
WHERE BOARD_MEMBER.MEM_ID = BOARD.MEM_ID;


-- 게시글 번호, 게시글 제목, 게시글 작성자, 게시글 작성일, 게시글 내용
-- 댓글 작성일, 댓글 작성자 id, 댓글 내용

SELECT B.BOARD_NUM, TITLE, B.MEM_ID, CREATE_DATE, CONTENT, 
		REPLY_DATE, R.MEM_ID, REPLY_CONTENT, REPLY_NUM
FROM board B, board_reply R
WHERE B.BOARD_NUM = R.BOARD_NUM
AND B.BOARD_NUM = 1;




SELECT * FROM board;


CREATE TABLE TEST_ITEM(
	ITEM_CODE INT AUTO_INCREMENT PRIMARY KEY
	, ITEM_NAME VARCHAR(50) NOT NULL
);

INSERT INTO TEST_ITEM VALUES(1, '상품1');
INSERT INTO TEST_ITEM VALUES(2, '상품2');
INSERT INTO TEST_ITEM VALUES(3, '상품3');

SELECT * FROM TEST_ITEM;

CREATE TABLE TEST_ORDER(
	ORDER_NUM INT AUTO_INCREMENT PRIMARY KEY
	, BUYER VARCHAR(50) NOT NULL
	, ITEM_CODE INT NOT NULL REFERENCES TEST_ITEM(ITEM_CODE) ON DELETE CASCADE
);

DROP TABLE TEST_ORDER;

INSERT INTO TEST_ORDER VALUES(1, '김자바', 1);
INSERT INTO TEST_ORDER VALUES(2, '김자바', 1);
INSERT INTO TEST_ORDER VALUES(3, '김자바', 2);

DELETE FROM TEST_ITEM WHERE ITEM_CODE = 1;

SELECT * FROM TEST_ORDER;


SELECT BOARD_NUM, TITLE, MEM_ID, CREATE_DATE
        FROM BOARD
        WHERE MEM_ID LIKE '%a';
        
        
        
        
INSERT INTO board(
   TITLE
   , CONTENT
   , MEM_ID
) VALUES(
   'test'
   , '1234'
   , 'admin'
);

SELECT *FROM board;

SELECT BOARD_NUM
   , TITLE
   , MEM_ID
   , CREATE_DATE
FROM board
LIMIT 5
ORDER BY BOARD_NUM DESC;

-- 테이블에 존재하는 데이터 갯수 조회
-- COUNT() <- 안에 값은 PK를 넣어주는게 좋음
SELECT COUNT(BOARD_NUM)
FROM board;


SELECT BOARD_NUM
   , TITLE
   , MEM_ID
   , CREATE_DATE
FROM BOARD
ORDER BY BOARD_NUM DESC
LIMIT 5 OFFSET (5-1);

