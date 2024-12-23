
CREATE TABLE MY_MEMBER(
	MEM_NUM INT PRIMARY KEY
	, MEM_ID VARCHAR (50) NOT NULL
	, MEM_PW VARCHAR (50) NOT NULL
	, MEM_NAME VARCHAR (30) NOT NULL
	, MEM_AGE INT 
	, MEM_EMAIL VARCHAR (50)
);

-- 1번
INSERT INTO MY_MEMBER(
	MEM_NUM
	, MEM_ID
	, MEM_PW
	, MEM_NAME
	, MEM_AGE
	, MEM_EMAIL
) VALUES(
	4
	, 'ABC'
	, 'ABC'
	, '이름'
	, 20
	, 'adss@email.com'
);

-- 2번
DELETE FROM MY_MEMBER;

-- 3번
UPDATE MY_MEMBER
SET MEM_NAME = '김바자'
	, MEM_ID = 'KIMJAVA'
WHERE MEM_NUM = 1;

-- 4번
SELECT EMPNO, ENAME, SAL, COMM
FROM emp
WHERE SAL >= 500 && SAL <= 3000
AND COMM IS NOT NULL;

-- 5번
SELECT EMPNO, ENAME, HIREDATE
FROM emp
WHERE ENAME LIKE '%기' OR ENAME LIKE '%김%'
ORDER BY EMPNO DESC;

SELECT * FROM emp;

-- 6번
SELECT EMPNO, ENAME, DEPTNO,
	CASE 
		WHEN DEPTNO = 10 THEN '영업부'
		WHEN DEPTNO = 20 THEN '영업부'
		WHEN DEPTNO = 30 THEN '개발부'
		ELSE '생산부'
	END AS DNAME
FROM emp;

-- 7번
SELECT EMPNO, ENAME, HIREDATE, IFNULL(COMM, 0) AS COMM
FROM emp
WHERE MONTH(HIREDATE) = 1
ORDER BY HIREDATE ASC;

-- 8번
SELECT SUM(SAL), AVG(SAL), IFNULL(AVG(COMM), 0) AS COMM
FROM emp
GROUP BY (DEPTNO)
ORDER BY SUM(SAL) DESC;

-- 9번

SELECT * FROM emp;
SELECT * FROM dept;

SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO
		, (SELECT DNAME FROM dept WHERE DEPTNO = emp.DEPTNO) AS DNAME
FROM emp
WHERE DEPTNO = (SELECT DEPTNO FROM dept WHERE DNAME = '인사부');

-- 10번
SELECT EMPNO, ENAME, HIREDATE, SAL, E.DEPTNO, DNAME
FROM emp E, dept D
WHERE E.DEPTNO = D.DEPTNO
AND DNAME != '인사부'
AND SAL >= 500
ORDER BY EMPNO DESC, ENAME ASC;




































