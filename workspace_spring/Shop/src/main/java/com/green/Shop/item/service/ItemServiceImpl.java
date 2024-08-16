package com.green.Shop.item.service;

import com.green.Shop.item.vo.CartVO;
import com.green.Shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ItemVO> getItemList() {
        return sqlSession.selectList("itemMapper.getItemList");
    }

    @Override
    public ItemVO getItemDetail(int itemCode) {
        return sqlSession.selectOne("itemMapper.getItemDetail", itemCode);
    }

    @Override
    public void insertCart(CartVO cartVO) {
        sqlSession.insert("itemMapper.insertCart", cartVO);
    }

    @Override
    public List<CartVO> getCartList(String memId) {
        return sqlSession.selectList("itemMapper.getCartList", memId);
    }

    @Override
    public void deleteItem(int cartCode) {
        sqlSession.delete("itemMapper.deleteItem", cartCode);
    }

    @Override
    public void updateCartCnt(CartVO cartVO) {
        sqlSession.update("itemMapper.updateCartCnt", cartVO);
    }


}
