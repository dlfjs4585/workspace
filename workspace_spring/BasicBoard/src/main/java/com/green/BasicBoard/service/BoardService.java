package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;

import java.util.List;

public interface BoardService {

    // 데이터 가져오기
    List<BoardVO> getBoardList(SearchVO searchVO);

    //제목 클릭 시 게시글 상세 페이지 이동
    BoardVO getBoardNum(int boardNum);

    // 글등록
    void insert(BoardVO boardVO);

    void setBoardList(BoardVO boardVO);

    void boardDelete(int boardNum);

    void updateReadCnt(int boardNum);
}
