package com.green.DB_score.service;

import com.green.DB_score.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList();

    void insert(BoardVO boardVO);

    BoardVO getBoardNum(int boardNum);

    void setBoardList(BoardVO boardVO);

    void delete(int boardNum);
}
