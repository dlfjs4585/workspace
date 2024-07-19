package com.green.ReactItem.service;

import com.green.ReactItem.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ItemVO> getItemInfo() {
        return sqlSession.selectList("itemMapper.getItemInfo");
    }

    @Override
    public ItemVO getItemDetail(int itemNum) {
        return sqlSession.selectOne("itemMapper.getItemDetail", itemNum);
    }

    @Override
    public void updateItem(ItemVO itemVO) {
        sqlSession.update("itemMapper.updateItem", itemVO);
    }

    @Override
    public void regItem(ItemVO itemVO) {
        sqlSession.insert("itemMapper.regItem", itemVO);
    }
}
