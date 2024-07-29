package com.green.CarManagement.service;

import com.green.CarManagement.vo.CarVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 차량 등록
    @Override
    public void insertCarInfo(CarVO carVO) {
        sqlSession.insert("carMapper.insertCarInfo", carVO);
    }

    @Override
    public List<CarVO> getCarList() {
        return sqlSession.selectList("carMapper.getCarList");
    }

    @Override
    public List<CarVO> getCarNameList() {
        return sqlSession.selectList("carMapper.getCarNameList");
    }
}
