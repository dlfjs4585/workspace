package com.green.CarManagement.service;

import com.green.CarManagement.vo.CarVO;

import java.util.List;

public interface CarService {

    // 차량 등록
    void insertCarInfo(CarVO carVO);

    // 차량 리스트 조회
    List<CarVO> getCarList();

    // 차량 이름 조회
    List<CarVO> getCarNameList();
}
