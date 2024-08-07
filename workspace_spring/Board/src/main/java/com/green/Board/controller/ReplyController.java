package com.green.Board.controller;

import com.green.Board.service.ReplyService;
import com.green.Board.vo.ReplyVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource(name = "replyService")
    private ReplyService replyService;

    //댓글 목록
    @GetMapping("/list/{boardNum}")
    public List<ReplyVO> getReply(@PathVariable("boardNum") int boardNum){
        return replyService.getReply(boardNum);
    }

    // 댓글 등록
    @PostMapping("/insertReply/{boardNum}")
    public void insertReply(@RequestBody ReplyVO replyVO){
        replyService.insertReply(replyVO);
    }

    // 댓글 삭제
    @DeleteMapping("/deleteReply/{replyNum}")
    public void deleteReply(@PathVariable("replyNum") int replyNum){
        replyService.deleteReply(replyNum);
    }

    //게시글에 댓글이 있을 때 삭제
    @DeleteMapping("/delete/{boardNum}")
    public void delete(@PathVariable("boardNum") int boardNum){
        replyService.delete(boardNum);
    }
}
