package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<VO> getBoardList() {
        List<VO> VOList = sqlSession.selectList("boardMapper.getBoardList");
        return VOList;
    }
}
