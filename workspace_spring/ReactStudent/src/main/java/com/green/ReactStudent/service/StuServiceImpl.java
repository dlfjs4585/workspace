package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StuVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<StuVO> getStuList() {
        return sqlSession.selectList("stuMapper.getStuList");
    }

    @Override
    public void insertStu(StuVO stuVO) {
        sqlSession.insert("stuMapper.insertStu", stuVO);
    }

    @Override
    public StuVO getStuDetail(int stuNum) {
        return sqlSession.selectOne("stuMapper.getStuDetail", stuNum);
    }

    @Override
    public void delStu(int stuNum) {
        sqlSession.delete("stuMapper.delStu", stuNum);
    }

    @Override
    public void updateScore(StuVO stuVO) {
        sqlSession.update("stuMapper.updateScore", stuVO);
    }
}
