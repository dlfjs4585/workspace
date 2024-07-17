package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.BoardService;
import com.green.ReactBoard.vo.VO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController 어노테이션이 붙은 클래스는 컨트롤러 역할을 한다.
// Controller 어노테이션과 다른 점
// 1. 해당 클래스의 리턴은 html 파일명이 아니다.
// 2. return 값은 react 로 만든 화면에 보여줄 데이터를 return
// 3. method 의 return type 을 잘 지정해야 한다!!!!


@RestController
public class BoardController {
    @Resource(name = "boardService")
    private BoardService boardService;


    // 게시글 목록 조회
    @GetMapping("/boardList")
    public List<VO> getBoardList(){
        return boardService.getBoardList();
    }

    // 게시글 상세 페이지
    @GetMapping("/boardDetail/{boardNum}")
    public VO getBoardDetail(@PathVariable("boardNum") int boardNum){
        return boardService.getBoardDetail(boardNum);
    }

    // 게시글 등록
    @PostMapping("/regBoard")
    public void regBoard(@RequestBody VO vo){
        System.out.println(vo);
        boardService.regBoard(vo);
    }

    // 게시글 삭제
    @DeleteMapping("/deleteBoard/{boardNum}")
    public void deleteBoard(@PathVariable("boardNum") int boardNum){
        boardService.deleteBoard(boardNum);
    }
}
