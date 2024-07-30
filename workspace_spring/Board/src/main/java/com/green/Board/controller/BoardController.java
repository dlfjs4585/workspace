package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.SearchVO;
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

    // 게시글 목록 조회
    // 제목, 작성자로 게시글 조회
    // requestBody 에 false 넣으면 넘어오는 데이터가 없어도 사용가능
    @PostMapping("/list")
    public List<BoardVO> getBoardList(@RequestBody(required = false) SearchVO searchVO){
        log.info(searchVO.toString());
        return boardService.getBoardList(searchVO);
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

    // 게시글 삭제
    @DeleteMapping("/delete/{boardNum}")
    public void deleteBoard(@PathVariable("boardNum") int boardNum){
        System.out.println(boardNum);
        boardService.deleteBoard(boardNum);
    }

}
