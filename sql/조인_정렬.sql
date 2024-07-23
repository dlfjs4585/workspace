
-- 여러 테이블의 내용을 동시에 조회하기(조인, JOIN)
SELECT * FROM emp;	
SELECT * FROM dept;

-- 사원번호, 사원명, 부서명을 조회
-- EMP 테이블에서 DEPTNO 확인 -> 20
-- DEPT 테이블에서 DEPTNO가 20인 데이터 확인

-- JOIN 조건 : 두 테이블이 공통으로 지니는 컬럼의 값이 같은 데이터만 조회
-- WHERE 에는 테이블명이 꼭 들어가야한다.
SELECT EMPNO, ENAME, DNAME
FROM emp, dept
WHERE emp.DEPTNO = dept.DEPTNO;

-- JOIN + 별칭
-- AS가 없어도 별칭 사용가능
SELECT EMPNO AS 사원버호
	, ENAME 사원명
	, 사원.SAL
FROM emp 사원;


-- 직급이 '대리'인 사원들의
-- 사원번호, 사원명, 직급, 부서번호, 부서명, 부서의 지역 조회

SELECT EMPNO, ENAME, JOB, DNAME, LOC, E.DEPTNO, D.DEPTNO
FROM emp E, dept D
WHERE E.DEPTNO = D.DEPTNO
AND JOB = '대리';


-- 조회 시 데이터를 정렬하여 조회하기
SELECT * FROM emp;


-- 사번, 사원명, 급여를 조회, 급여 기준 오름 차순 정렬(ORDER BY)
-- 오름차순 : ASC (생략가능)
-- 내림차순 : DESC
SELECT EMPNO, ENAME, SAL
FROM emp
ORDER BY SAL;

-- 부서번호가 30번이 아닌 사원들의
-- 사원명, 부서번호를 조회하되, 사원명 기준 내림차순으로 정렬
SELECT ENAME, DEPTNO
FROM emp
WHERE DEPTNO != 30
ORDER BY ENAME DESC;

SELECT * FROM emp;
SELECT * FROM dept;

-- 부서명이 인사부가 아니면서 급여가 300 이상인 사원들의
-- 사번, 사원명, 부서번호, 부서명, 급여를 조회하되
-- 부서번호 기준 오름차순으로 정렬
SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME, SAL
FROM emp, dept
WHERE DNAME != '인사부'
AND SAL >= 300
AND emp.DEPTNO = DEPT.DEPTNO
ORDER BY EMP.DEPTNO;


SELECT * FROM emp;
SELECT * FROM dept;


-- 직급 기준 정렬 후, 급여 기준으로 정렬
SELECT EMPNO, ENAME, JOB, SAL
FROM emp
ORDER BY JOB ASC, SAL ASC;












