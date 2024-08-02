package com.green.Shop.member.service;

import com.green.Shop.member.vo.ShopMemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopMemberService")
public class ShopMemberServiceImpl implements ShopMemberService {

    @Autowired
    private SqlSessionTemplate sqlSession;

    // 유저 회원 가입
    public void insertMember(ShopMemberVO shopMemberVO){
        sqlSession.insert("shopMemberMapper.insertMember", shopMemberVO);
    }

    @Override
    public List<ShopMemberVO> getId() {
        return sqlSession.selectList("shopMemberMapper.getId");
    }

}
