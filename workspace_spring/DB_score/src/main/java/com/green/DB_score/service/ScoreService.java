package com.green.DB_score.service;

import com.green.DB_score.vo.ScoreVO;

import java.util.List;

public interface ScoreService {

    List<ScoreVO> getStuList();

    void insert(ScoreVO scoreVO);

    ScoreVO getStuNum(int stuNum);

    void setStuList(ScoreVO vo);

    void delete(int stuNum);


}
