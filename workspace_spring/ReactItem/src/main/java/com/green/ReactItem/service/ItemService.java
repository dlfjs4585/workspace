package com.green.ReactItem.service;

import com.green.ReactItem.vo.ItemVO;

import java.util.List;

public interface ItemService {
    // 상품 목록 조회
    List<ItemVO> getItemInfo();

    // 상품 세부 정보 조회
    ItemVO getItemDetail(int itemNum);

    // 상품 정보 수정
    void updateItem(ItemVO itemVO);

    // 상품 등록
    void regItem(ItemVO itemVO);
}
