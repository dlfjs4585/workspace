package com.green.Board.vo;

// 페이징 처리를 위한 모든 정보를 갖는 클래스

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PageVO{
    
    // 전체 데이터 수
    private int totalDataCnt;

    // 전체 페이지 수
    private int totalPageCnt;
    
    // 한 페이지에 보여지는 데이터 수
    private int displayDataCnt;
    
    // 현제 페이지
    private int nowPage;
    
    // 한 화면에 보여지는 페이지 수
    private int displayPageCnt;
    
    // 화면에 보이는 시작 페이지
    private int beginPage;
    
    // 화면에 보이는 마지막 페이지
    private int endPage;

    // 이전 버튼 유무
    private boolean prev;

    // 다음 버튼 유무
    private boolean next;

    // 생성자
    // 매개변수 : db에서 조회한 전체 데이터 수
    public PageVO(int totalDataCnt){
        nowPage = 1;
        displayPageCnt = 5;
        displayDataCnt = 5;
        this.totalDataCnt = totalDataCnt;
    }

    // 모든 페이지 정보를 세팅하는 메서드
    public void setPageInfo(){
        // 전체 페이지 수
        this.totalPageCnt = (int) Math.ceil(totalDataCnt / (double) displayDataCnt);

        // 마지막 페이지 계산
        endPage = ((int) Math.ceil((double) nowPage / (double) displayPageCnt)) * displayPageCnt;

        // 마지막 페이지가 전체 페이지 수 일때, 아닐때
        if(endPage > totalPageCnt){
            endPage = totalPageCnt;
        }

        // 시작 페이지 계산
        beginPage = endPage - displayPageCnt + 1;
        if(beginPage < 1){
            beginPage = 1;
        }

        // 이전 버튼 유무
        prev = beginPage != 1;

        // 다음 버튼 유무
        next = endPage != totalPageCnt;
    }
}
