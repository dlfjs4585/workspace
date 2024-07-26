package com.green.Board.service;

import com.green.Board.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    List<ReplyVO> getReply(int boardNum);

    // 댓글 등록
    void insertReply(ReplyVO replyVO);

    // 댓글 삭제
    void deleteReply(int replyNum);

}
