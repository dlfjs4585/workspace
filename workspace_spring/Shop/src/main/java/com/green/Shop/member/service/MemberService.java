package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    // 회원가입
    void join(MemberVO memberVO);

    // 사용 가능 : true, 사용 불가능 : false
    boolean isEnableId(String memId);

    // 로그인 기능
    MemberVO login(MemberVO memberVO);
}
