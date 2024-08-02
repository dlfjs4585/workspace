package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public Map<String , Object > getBoardList(@RequestBody(required = false) SearchVO searchVO){

        log.info(searchVO.toString());

        // 전체 게시글 수
        int totalDataCnt = boardService.getBoardCnt();

        // 페이지 정보를 담을 수 있는 PageVO 객체 생성
        PageVO pageInfo = new PageVO(totalDataCnt);

        pageInfo.setNowPage(searchVO.getPageNo());

        pageInfo.setPageInfo();
        log.info(pageInfo.toString());

        //return boardService.getBoardList(searchVO);
        // react 로 가져갈 모든 데이터를 담을 변수
        Map<String , Object > map = new HashMap<>();

        // 페이징 정보가 담긴 데이터
        map.put("pageInfo", pageInfo );

        // 게시글 목록 조회 데이터
        map.put("boardList", boardService.getBoardList(pageInfo) );
        return map;
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
