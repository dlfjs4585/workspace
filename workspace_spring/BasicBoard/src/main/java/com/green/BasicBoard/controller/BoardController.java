package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    @Resource(name = "boardService")
    private BoardServiceImpl boardService;
    List<BoardVO> boardVOList = new ArrayList<>();

    //메인 화면
    @RequestMapping("/")
    public String getBoardList(Model model, SearchVO searchVO){
        //searchVO 데이터 검사
        System.out.println(searchVO);

        //목록 조회
        List<BoardVO> boardVOList = boardService.getBoardList(searchVO);
        model.addAttribute("boardVOList",boardVOList);
        return "board_list";
    }

    // 글쓰기 폼 이동
    @GetMapping("/writeForm")
    public String writeForm(){
        return "write_form";
    }

    // 글등록 + 목록 페이지 이동
    @PostMapping("/boardUp")
    public String boardUpdate(BoardVO boardVO){
        boardService.insert(boardVO);
        boardVOList.add(boardVO);
        return "redirect:/";
    }

    // 글 상세 조회 페이지 이동
    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(name = "boardNum") int boardNum, Model model){
        boardService.updateReadCnt(boardNum);

        BoardVO vo = boardService.getBoardNum(boardNum);
        model.addAttribute("board", vo);

        return "board_detail";
    }

    // 글 수정 화면
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "boardNum") int boardNum, Model model){
        model.addAttribute("board", boardService.getBoardNum(boardNum));
        return "update_form";
    }

    // 글 수정 페이지 + 상세 페이지 이동
    @PostMapping("/boardUpdate")
    public String boardUpdate(@RequestParam(name = "boardNum") int boardNum, BoardVO boardVO){
        BoardVO vo = new BoardVO();
        vo.setBoardNum(boardNum);
        vo.setTitle(boardVO.getTitle());
        vo.setWriter(boardVO.getWriter());
        vo.setContent(boardVO.getContent());
        vo.setReadCnt(boardVO.getReadCnt());
        vo.setCreateDate(boardVO.getCreateDate());

        boardService.setBoardList(vo);
        return "redirect:/boardDetail?boardNum=" + boardNum;
    }

    // 글 삭제
    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam(name = "boardNum") int boardNum){
        boardService.boardDelete(boardNum);
        return "redirect:/";
    }

}
