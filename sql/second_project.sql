-- 환자 및 의사의 데이터를 담을 테이블
CREATE TABLE HOSPITAL_MEMBER(
  MEM_NUM INT AUTO_INCREMENT PRIMARY KEY -- 멤버별 pk
  , EMAIL VARCHAR(50) NOT NULL -- 아이디로 사용할 email
  , MEM_PW VARCHAR(50) NOT NULL -- 비밀번호
  , MEM_NAME VARCHAR(30) NOT NULL -- 이름
  , MEM_TEL VARCHAR(30) UNIQUE -- 전화번호
  , MEM_ROLE VARCHAR(30) DEFAULT 'USER' -- 기본적으로 가입하면 user
  , latitude DOUBLE DEFAULT 0
  , longitude DOUBLE DEFAULT 0
);

SELECT * FROM hospital_member;
DELETE FROM hospital_member;
DROP TABLE hospital_member;

UPDATE hospital_member
SET LATITUDE = 20.542117,
LONGITUDE = 60.338326
WHERE MEM_NUM = 3;




SELECT * FROM location;