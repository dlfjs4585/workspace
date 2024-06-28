package com.green.DB_score.service;

import com.green.DB_score.vo.ScoreVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ScoreVO> getStuList() {
        List<ScoreVO> scoreVOList = sqlSession.selectList("scoreMapper.getStuList");
        return scoreVOList;
    }

    @Override
    public void insert(ScoreVO scoreVO) {
        sqlSession.insert("scoreMapper.insert", scoreVO);
    }

    @Override
    public ScoreVO getStuNum(int stuNum) {

        ScoreVO scoreVO = sqlSession.selectOne("scoreMapper.getStuNum", stuNum);

        return scoreVO;
    }

    @Override
    public void setStuList(ScoreVO vo) {
       sqlSession.selectOne("scoreMapper.setStuList", vo);
    }

    @Override
    public void delete(int stuNum) {
        sqlSession.delete("scoreMapper.delete", stuNum);
    }


}
