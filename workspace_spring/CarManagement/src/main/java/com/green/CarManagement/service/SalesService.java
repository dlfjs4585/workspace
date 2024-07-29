package com.green.CarManagement.service;

import com.green.CarManagement.vo.CarVO;
import com.green.CarManagement.vo.SalesVO;

import java.util.List;

public interface SalesService {


    // 판매 정보 등록
    void insertSaleInfo(SalesVO salesVO);

    List<SalesVO> getCarList();

}
