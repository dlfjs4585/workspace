package com.green.DB_Member.service;

import com.green.DB_Member.vo.MemberVO;

import java.util.List;

//인터페이스에서는 작성한 쿼리를 실행할 메서드를 정의
//메서드의 매개변수 : 실행할 쿼리에 빈값을 채워주는 데이터
//메서드의 리턴타입 : 쿼리 실행결과 데이터베이스에서 가져오는 데이터 타입
public interface DBService {

    //회원번호가 1번인 회원의 이름을 조회하는 쿼리를 실행할 메서드
    String  select1();

    //전달된 회원번호를 지닌 회원의 나이를 조회
    int select2(int memNum);

    //전달받은 나이 이상의 회원의 이름을 조회
    List<String> select3(int memAge);

    //전달받은 회원번호를 지닌 회원의 회원번호, 이름, 나이, 주소를 조회
    MemberVO select4(int memNum);

    //모든 회원의 회원번호, 이름, 나이, 주소를 조회
    List<MemberVO> select5();

    //전달받은 회원번호를 가진 회원을 삭제
    //delete, update, insert 리턴 타입 : void, int
    int delete(int memNum);


    void insert(MemberVO memberVO);

    //전달받은 회원번호를 지닌 회원의 이름, 나이, 주소를 변경
    int update(MemberVO memberVO);

}
