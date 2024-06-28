package com.green.DB_score.controller;

import com.green.DB_score.service.BoardServiceImpl;
import com.green.DB_score.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    @Resource(name = "boardService")
    private BoardServiceImpl boardService;
    List<BoardVO> boardVOList = new ArrayList<>();

    //게시판 메인
    @GetMapping("/boardList")
    public String boardList(Model model){
        List<BoardVO> boardVOList = boardService.getBoardList();
        model.addAttribute("boardVOList",boardVOList);
        return "board_list";
    }

    //글작성 폼으로 이동
    @GetMapping("/writeForm")
    public String writeForm(){
        return "board_write_form";
    }

    //글작성 + 게시판 메인으로 이동
    @PostMapping("/boardUp")
    public String boardUp(BoardVO boardVO){
        boardService.insert(boardVO);
        boardVOList.add(boardVO);
        return "redirect:/boardList";
    }

    //글 상세 조회 화면 이동
    @GetMapping("boardDetail")
    public String boardDetail(@RequestParam(name = "boardNum") int boardNum, Model model){
        BoardVO vo = boardService.getBoardNum(boardNum);
        model.addAttribute("board", vo);
        return "board_detail";
    }

    //글 수정 페이지
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "boardNum") int boardNum, Model model){
        BoardVO vo = boardService.getBoardNum(boardNum);
        model.addAttribute("board", vo);
        return "update_form";
    }

    //글 수정 + 게시판 메인 이동
    @PostMapping("/updateBoardList")
    public String updateBoardList(@RequestParam(name = "boardNum") int boardNum, BoardVO boardVO){
        BoardVO vo = new BoardVO();
        vo.setBoardNum(boardNum);
        vo.setTitle(boardVO.getTitle());
        vo.setWriter(boardVO.getWriter());
        vo.setContent(boardVO.getContent());

        boardService.setBoardList(vo);
        return "redirect:/boardDetail?boardNum=" + boardNum;
    }

    //글 삭제
    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam(name = "boardNum") int boardNum){
        boardService.delete(boardNum);
        return "redirect:/boardList";
    }
}
