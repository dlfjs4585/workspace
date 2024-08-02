package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    void join(MemberVO memberVO);

    boolean getId(String id);
}
