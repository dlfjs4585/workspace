package com.green.ListPractice.vo;

import lombok.Data;

//VO : Value Object
//DTO (BoardDTO) : Data Transfer Object
@Data
public class BoardVO {
    private int boardNum;
    private String title;
    private String writer;
    private String createDate;
    private String content;
}
