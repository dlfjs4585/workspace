package com.green.DB_score.vo;

import lombok.Data;

@Data
public class BoardVO {

    private int boardNum;
    private String title;
    private String writer;
    private String  content;
    private int readCnt;

}
