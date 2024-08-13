package com.green.Shop.item.vo;

import lombok.Data;

import java.util.List;

@Data
public class CartVO {
    private int cartCode;
    private int cartCnt;
    private int itemCode;
    private List<ItemVO> itemList;
    private List<ImgVO> imgList;
    private String memId;
    private String cartDate;
}
