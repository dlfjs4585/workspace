package com.green.Shop.item.service;

import com.green.Shop.item.vo.CartVO;
import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface ItemService {

    List<ItemVO> getItemList();

    ItemVO getItemDetail(int itemCode);

    void insertCart(CartVO cartVO);

    List<CartVO> getCartList(String memId);
}
