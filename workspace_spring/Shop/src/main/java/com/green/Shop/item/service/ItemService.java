package com.green.Shop.item.service;

import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface ItemService {

    List<ItemVO> getItemList();

    ItemVO getItemDetail(int itemCode);

}
