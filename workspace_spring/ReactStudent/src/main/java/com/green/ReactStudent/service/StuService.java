package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StuVO;

import java.util.List;

public interface StuService {

    // 학생 목록 조회
    List<StuVO> getStuList();

    // 학생 등록
    void insertStu(StuVO stuVO);

    // 학생 상세보기
    StuVO getStuDetail(int stuNum);

    // 학생 정보 삭제
    void delStu(int stuNum);

    // 점수 등록
    void updateScore(StuVO stuVO);
}
