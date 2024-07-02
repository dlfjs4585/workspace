package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<BoardVO> getBoardList(SearchVO searchVO) {
        List<BoardVO> boardVOList = sqlSession.selectList("boardMapper.getBoardList", searchVO);
        return boardVOList;
    }

    @Override
    public BoardVO getBoardNum(int boardNum) {
        BoardVO vo = sqlSession.selectOne("boardMapper.getBoardNum", boardNum);
        return vo;
    }

    @Override
    public void insert(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert", boardVO);
    }

    @Override
    public void setBoardList(BoardVO boardVO) {
        sqlSession.update("boardMapper.setBoardList", boardVO);
    }

    @Override
    public void boardDelete(int boardNum) {
        sqlSession.delete("boardMapper.boardDelete", boardNum);
    }

    /* 조회수 증가*/
    @Override
    public void updateReadCnt(int boardNum) {
        sqlSession.update("boardMapper.updateReadCnt");
    }


}
