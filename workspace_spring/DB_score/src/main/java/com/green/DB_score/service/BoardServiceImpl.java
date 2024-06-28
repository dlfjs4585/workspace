package com.green.DB_score.service;

import com.green.DB_score.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardVOList = sqlSession.selectList("boardMapper.getBoardList");
        return boardVOList;
    }

    @Override
    public void insert(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert", boardVO);
    }

    @Override
    public BoardVO getBoardNum(int boardNum) {
        BoardVO vo = sqlSession.selectOne("boardMapper.getBoardNum", boardNum);
        return vo;
    }

    @Override
    public void setBoardList(BoardVO boardVO) {
        sqlSession.selectOne("boardMapper.setBoardList", boardVO);
    }

    @Override
    public void delete(int boardNum) {
        sqlSession.delete("boardMapper.delete", boardNum);
    }
}
