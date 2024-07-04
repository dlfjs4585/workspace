package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReactController {
    @Resource(name = "boardService")
    private BoardServiceImpl boardService;
    List<BoardVO> boardVOList = new ArrayList<>();

    //메인 화면
    @RequestMapping("/list")
    public List<BoardVO> getBoardList(Model model, SearchVO searchVO){

        //목록 조회
        List<BoardVO> boardVOList = boardService.getBoardList(searchVO);
        return boardVOList;
    }



}
