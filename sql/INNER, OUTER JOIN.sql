CREATE TABLE JOIN_STU (
	STU_NUM INT PRIMARY KEY
	, STU_NAME VARCHAR(50)
	, MAJOR VARCHAR(50)
);



INSERT INTO JOIN_STU VALUES (1, '김자바', '자바전공');
INSERT INTO JOIN_STU VALUES (2, '이자바', '자바전공');
INSERT INTO JOIN_STU VALUES (3, '박자바', '자바전공');
INSERT INTO JOIN_STU VALUES (4, '윤회계', '회계전공');
INSERT INTO JOIN_STU VALUES (5, '정회계', '회계전공');
INSERT INTO JOIN_STU VALUES (6, '최회계', '회계전공');

CREATE TABLE JOIN_SCORE (
	SCORE_NUM INT PRIMARY KEY
	, SCORE INT
	, STU_NUM INT
);

INSERT INTO JOIN_SCORE VALUES (1, 80, 1);
INSERT INTO JOIN_SCORE VALUES (2, 70, 2);
INSERT INTO JOIN_SCORE VALUES (3, 70, 5);
INSERT INTO JOIN_SCORE VALUES (4, 85, 6);
INSERT INTO JOIN_SCORE VALUES (5, 89, 7);
INSERT INTO JOIN_SCORE VALUES (6, 77, 8);


SELECT * FROM join_stu;
SELECT * FROM join_score;

-- 아래 쿼리의 실행 결과 조회되는 데이터 수는 몇개인가?
SELECT STU.STU_NUM, STU_NAME, SCORE
FROM JOIN_STU STU, JOIN_SCORE SCORE
WHERE STU.STU_NUM = SCORE.STU_NUM;


-- 조인은 각 데이터베이스별 문법 존재, 
-- 모든 데이터베이스에서 사용가능한 문법 'ANSI 문법'
-- , 대신 INNER JOIN 
-- 조인 조건은 WHERE절이 아니라 ON절에 작성
-- INNER JOIN -> JOIN 대체 가능

SELECT STU.STU_NUM, STU_NAME, SCORE
FROM JOIN_STU STU INNER JOIN JOIN_SCORE SCORE
ON STU.STU_NUM = SCORE.STU_NUM -- ON에는 조인 조건만 들어올 수 있음
WHERE STU.STU_NUM = 1;


-- JOIN은 INNER JOIN, OUTER JOIN 두 가지로 구분
-- OUTER JOIN : RIGHT OUTER JOIN, LEFT OUTER JOIN
-- 조회를 할때는 먼저 적는 테이블을 기준으로 한다.

-- 모든 학생에 대한 점수를 조회
SELECT STU.STU_NUM, STU_NAME, IFNULL(SCORE, 0) AS SCORE
FROM JOIN_STU STU LEFT OUTER JOIN JOIN_SCORE SCORE
ON STU.STU_NUM = SCORE.STU_NUM;

SELECT STU.STU_NUM, STU_NAME, IFNULL(SCORE, 0) AS SCORE
FROM JOIN_STU STU RIGHT OUTER JOIN JOIN_SCORE SCORE
ON STU.STU_NUM = SCORE.STU_NUM;

-- MARIA DB에서는 불가능한 방법
-- OUTER JOIN 사용하기
SELECT STU.STU_NUM, STU_NAME, SCORE
FROM JOIN_STU STU, JOIN_SCORE SCORE
-- WHERE STU.STU_NUM = SCORE.STU_NUM;  INNER JOIN
-- WHERE STU.STU_NUM = SCORE.STU_NUM(+);  LEFT OUTER JOIN
-- WHERE STU.STU_NUM(+) = SCORE.STU_NUM;  RIGHT OUTER JOIN







