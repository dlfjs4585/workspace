package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {
    @Resource(name = "boardService")
    private BoardService boardService;

    //게시글 목록 조회
    @GetMapping("/list")
    public List<BoardVO> getBoardList(){
        return boardService.getBoardList();
    }

    //게시글 등록
    @PostMapping("/insert")
    public void insertBoard(@RequestBody BoardVO boardVO){
        boardService.insertBoard(boardVO);
    }

    //게시글 상세보기
    @GetMapping("/detail/{boardNum}")
    public BoardVO getBoardDetail(@PathVariable("boardNum") int boardNum){
        return boardService.getBoardDetail(boardNum);
    }

    //게시글 수정
    @PutMapping("/update/{boardNum}")
    public void updateBoard(@RequestBody BoardVO boardVO){
        boardService.updateBoard(boardVO);
    }






}
