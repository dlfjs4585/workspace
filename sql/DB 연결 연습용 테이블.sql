
-- DB 연결 연습용 테이블
CREATE TABLE TEST_MEMBER(
	MEM_NUM INT PRIMARY KEY
	, MEM_NAME VARCHAR(50)
	, MEM_AGE INT
	, MEM_ADDR VARCHAR(50)
	
);

SELECT * FROM test_member;

-- 데이터 삽입
INSERT INTO test_member VALUES(1, '홍길동', 20, '서울시');
INSERT INTO test_member VALUES(2, '김길동', 21, '울산시');
INSERT INTO test_member VALUES(3, '박길동', 23, '대전시');
INSERT INTO test_member VALUES(4, '이길동', 21, '광주시');
INSERT INTO test_member VALUES(5, '정길동', 24, '부산시');
COMMIT;
