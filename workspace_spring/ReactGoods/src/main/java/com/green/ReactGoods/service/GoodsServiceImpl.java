package com.green.ReactGoods.service;

import com.green.ReactGoods.vo.GoodsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<GoodsVO> getGoodsInfo() {
        return sqlSession.selectList("goodsMapper.getGoodsInfo");
    }
}
