package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<CategoryVO> getCategoryList() {
        return sqlSession.selectList("adminMapper.getCategoryList");
    }

    @Override
    public void insertItem(ItemVO itemVO) {
        sqlSession.insert("adminMapper.insertItem", itemVO);
    }

    @Override
    public List<ItemVO> getItemList() {
        return sqlSession.selectList("adminMapper.getItemList");
    }
}
