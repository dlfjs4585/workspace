package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
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
}
