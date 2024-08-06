package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 회원가입
    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join", memberVO);
    }

    // 아이디 중복확인
    // 사용 가능 : true, 사용 불가능 : false
    @Override
    public boolean isEnableId(String memId) {
        return sqlSession.selectOne("memberMapper.isEnableId", memId) == null;
    }

    @Override
    public MemberVO login(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.login", memberVO);
    }

}
