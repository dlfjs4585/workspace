
-- 많이 사용하는 함수

SELECT 'JAVA';
-- 조건이 없으면 데이터 갯수 만큼 조회
SELECT 'JAVA' FROM board;

-- 문자열 나열 함수
SELECT 'JAVA', 'HELLO', CONCAT('JAVA', 'HELLO');

SELECT BOARD_NUM, TITLE, CONCAT(BOARD_NUM, '_', TITLE) AS BOARD_INFO
FROM board;

-- 문자열의 길이
SELECT 'JAVA', LENGTH('JAVA'), 'HELLO', LENGTH('HELLO');

-- 일부 문자열 추출
-- 첫번째 매개변수 : 원본 글
-- 두번째 매개변수 : 추출 시작 INDEX(1부터 시작)
-- 세번째 매개변수 : 추출될 문자열 갯수
SELECT 'ABCDEFG'
	, SUBSTRING('ABCDEFG', 3)
	, SUBSTRING('ABCDEFG', 3, 2);
	
-- UPPER : 대문자, LOWER : 소문자
SELECT 'Mysql', UPPER('Mysql'), LOWER('Mysql');	

-- 문자나 숫자의 자릿수 맞추기(빈공간(지정한 숫자)이 없으면 문자열(숫자 그대로 나오고), 공간이 남으면 세번째 매개변수로 값이 들어간다.)
SELECT LPAD('JAVA1234', 5, '#'), RPAD('JAVA', 5, '#');

-- 문자열의 좌, 우, 공백을 제거해주는 함수	
SELECT '  AA BB  ', LTRIM('  AA BB  '), RTRIM('  AA BB  '), TRIM('  AA BB  ');

-- 문자열 치환 함수
SELECT '010 1111 2222', REPLACE('010 1111 2222', ' ', '-');

-- 반올림
SELECT 123456, ROUND(123.456, 2);

-- SELECT는 연산가능, MOD : 나머지 연산자
SELECT 10+10, 2*3, 15/4, MOD(16,4);

-- NULL 데이터를 치환하는 함수
SELECT IFNULL(COMM, 0) FROM emp;

-- ----------------------------------------------------
-- 단일행 함수 : 데이터의 갯수와 상관없이 조회 결과 하나의 행 결과만 갖는 함수
-- SUM(), MAX(), MIN(), AVG(), COUNT()
	
SELECT * FROM emp;	

-- 모든 사원의 급여 총 합을 조회
-- SUM(10, 10) <- 이런 쿼리는 불가
SELECT SUM(SAL), SUM(COMM)FROM emp;

SELECT * FROM emp;		
-- SUM() 함수가 위의 함수와의 다른점
-- SUM() 함수는 데이터의 갯수와 상관없이 무조건 하나의 조회 결과를 가짐
SELECT LENGTH(ENAME), LENGTH(JOB) FROM emp;
	
-- *** 쿼리 조회시 조회하는 모든 컬럼의 조회 행 갯수는 모두 일치해야 한다.  매우 중요함!!!
-- 모든 사원의 이름과, 급여의 합을 조회 
SELECT ENAME, SUM(SAL) FROM emp;

-- 단일 행을 주의 할것.
SELECT SUM(SAL), MAX(SAL), MIN(SAL), AVG(SAL), COUNT(SAL) FROM emp;

-- 테이블이 이는 데이터의 수
SELECT COUNT(*) FROM emp;

-- 추천하는 방식 : COUNT(PK)
SELECT COUNT(EMPNO) FROM emp;

-- NULL 데이터를 COUNT에서 제외 함
SELECT COUNT(COMM) FROM emp;

SELECT * FROM emp;

-- NULL 값을 제외한 COMM의 평균을 구한 것.
SELECT AVG(COMM) FROM emp;

-- 평균 계산 시 NULL 데이터 주의
SELECT ROUND(AVG(IFNULL(COMM, 0)), 1) AS AVG FROM emp;
	

	
	
	
	
	
	
	
	
	
study_dbstudy_dbstudy_db