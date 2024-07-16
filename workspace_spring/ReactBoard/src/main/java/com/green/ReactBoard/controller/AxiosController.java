package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.AxiosService;
import com.green.ReactBoard.vo.MemberVO;
import com.green.ReactBoard.vo.VO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AxiosController {
    @Resource(name = "axiosService")
    private AxiosService axiosService;

    // 1번 버튼 클릭 시 호출되는 메서드
    @GetMapping("/getList")
    public List<VO> getList(){
        return axiosService.getList();
    }

    @PostMapping("/insertBoard")
    public void insertBoard(@RequestBody MemberVO memberVO){
        System.out.println(1);
        System.out.println(memberVO);
    }

    @PutMapping("/updateBoard")
    public int updateBoard(@RequestBody VO vo){
        System.out.println(vo);
        return 10;
    }

    @GetMapping("/detail/{boardNum}")
    public void detail(@PathVariable("boardNum") int boardNum){
        System.out.println(boardNum);
    }

}
