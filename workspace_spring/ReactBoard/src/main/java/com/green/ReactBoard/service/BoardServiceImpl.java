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

    // 게시글 상세 조회
    @Override
    public VO getBoardDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.getBoardDetail", boardNum);
    }

    // 게시글 등록
    @Override
    public void regBoard(VO vo) {
        sqlSession.insert("boardMapper.regBoard", vo);
    }

    // 게시글 삭제
    @Override
    public void deleteBoard(int boardNum) {
        sqlSession.delete("boardMapper.deleteBoard", boardNum);
    }


}
