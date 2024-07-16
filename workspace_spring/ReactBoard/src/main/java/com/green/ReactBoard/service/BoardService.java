package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.VO;

import java.util.List;

public interface BoardService {

    // 게시글 목록 조회
    List<VO> getBoardList();

    // 게시글 상세 정보 조회
    VO getBoardDetail(int boardNum);

    // 게시글 등록
    void setBoard(VO vo);
}
