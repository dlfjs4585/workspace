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
  , DEVICE_ID VARCHAR(100) 
);

SELECT * FROM hospital_member;
DELETE FROM hospital_member
WHERE MEM_NUM = 4;
DROP TABLE hospital_member;

INSERT INTO hospital_member(EMAIL, MEM_PW, MEM_NAME, MEM_TEL, MEM_ROLE)
VALUES('admin1', 'admin1', '관리자', '01012341234', 'ADMIN');

UPDATE hospital_member
SET LATITUDE = 35.54195015830728,
LONGITUDE = 129.3380802109104
WHERE MEM_NUM = 2;

SELECT * FROM location;

UPDATE hospital_member
SET
DEVICE_ID = 'asdaaddsdasd'
WHERE MEM_NUM = 8;


 SELECT MEM_NUM,
        EMAIL,
        MEM_NAME,
        MEM_TEL,
        latitude,
        longitude
        FROM hospital_member;