package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    List<CategoryVO> getCategoryList();

    void insertItem(ItemVO itemVO);

    List<ItemVO> getItemList();
}
