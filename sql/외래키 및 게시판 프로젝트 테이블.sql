
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
VALUES ('댓글2', 'java', 2);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글3', 'java', 1);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글4', 'admin', 1);
INSERT INTO BOARD_REPLY(REPLY_CONTENT, MEM_ID, BOARD_NUM) 
VALUES ('댓글5', 'admin', 2);


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






