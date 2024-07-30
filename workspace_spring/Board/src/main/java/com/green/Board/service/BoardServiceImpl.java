package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    //게시글 목록 조회
    // 제목, 작성자로 게시글 조회
    @Override
    public List<BoardVO> getBoardList(SearchVO searchVO) {
        return sqlSession.selectList("boardMapper.getBoardList", searchVO);
    }

    @Override
    public void insertBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insertBoard", boardVO);
    }

    @Override
    public BoardVO getBoardDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.getBoardDetail", boardNum);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        sqlSession.update("boardMapper.updateBoard", boardVO);
    }

    @Override
    public void deleteBoard(int boardNum) {
        sqlSession.delete("boardMapper.deleteBoard", boardNum);
    }

}
