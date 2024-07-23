package com.green.Board.service;

import com.green.Board.vo.MemberVO;

import java.util.List;

public interface MemberService {

    // 회원 가입
    void regMember(MemberVO memberVO);

    // 아이디 가져오기
    List<MemberVO> getMemId();

    // 로그인
    MemberVO login(MemberVO memberVO);

}
