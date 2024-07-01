 -- 테이블 삭제 (데이터 삭제와 구분하여야 함.)
 DROP TABLE basic_board;
 DELETE FROM BASIC_BOARD;
 -- 게시판 프로그램 테이블 생성
 CREATE TABLE BASIC_BOARD(
 	-- 컬럼명 자료형(데이터타입) [제약조건들]
 	BOARD_NUM INT AUTO_INCREMENT PRIMARY KEY 
 	, TITLE VARCHAR(50) NOT NULL
 	, WRITER VARCHAR(50) NOT NULL 
 	, CONTENT VARCHAR(100) 
 	, CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
 	, READ_CNT INT DEFAULT 0
 );
 
 SELECT * FROM basic_board;
 
  SELECT BOARD_NUM
            , TITLE
            , WRITER
            , CREATE_DATE
            , READ_CNT
        FROM BASIC_BOARD
        WHERE TITLE LIKE '%안녕%%';
        WHERE WRITER LIKE '%java%';
 

 
 
 
 
 