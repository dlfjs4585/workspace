package com.green.Shop.member.service;

import com.green.Shop.member.vo.ShopMemberVO;

import java.util.List;

public interface ShopMemberService {

    void insertMember(ShopMemberVO shopMemberVO);

    List<ShopMemberVO> getId();

}
