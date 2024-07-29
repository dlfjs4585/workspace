package com.green.CarManagement.service;

import com.green.CarManagement.vo.CarVO;
import com.green.CarManagement.vo.SalesVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesService")
public class SalesServiceImpl implements SalesService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public void insertSaleInfo(SalesVO salesVO) {
        sqlSession.insert("salesMapper.insertSaleInfo",salesVO);
    }

    @Override
    public List<SalesVO> getCarList() {
        return sqlSession.selectList("salesMapper.getCarList");
    }
}
