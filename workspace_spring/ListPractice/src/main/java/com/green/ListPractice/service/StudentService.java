package com.green.ListPractice.service;


import com.green.ListPractice.vo.StuVO;

import java.util.ArrayList;
import java.util.List;

//학생 관리 프로그램의 핵심 기능을 담당.(MVC에서 Model)
public class StudentService {

    List<StuVO> stuVOList = new ArrayList<>();

    //학생 목록을 조회하는 기능
    public List<StuVO> getStuList(){
        return stuVOList;
    }

    //학생 등록
    public void regStudent(StuVO stuVO){
        stuVOList.add(stuVO);
    }

    //학생 상세 조회
    public StuVO getStuDetail(int stuNum){
        //학번이 일치하는 학생을 저장할 공간.
        StuVO findStudent = null;
        for ( StuVO stuVO : stuVOList){
            if (stuVO.getStuNum() == stuNum){
                findStudent = stuVO;
            }
        }
        return findStudent;
    }

    //학생 삭제
    public void deleteStu(int stuNum){
        //삭제를 위해서는 삭제할 학생의 index 번호 필요
        //index를 알기 위해서는 학번 데이터가 필요함
        int index = 0;
        for (int i  = 0; i < stuVOList.size(); i++){
            if (stuVOList.get(i).getStuNum() == stuNum){
                index = i;
            }
        }
        stuVOList.remove(index);
    }

    //학생 정보 수정
    public void updateStu(StuVO stuVO){
        //리스트에서 정보를 수정하고자 하는 학생을 찾아
        // 그 학생의 정보를 input 태그 및 textarea에서 입력한 정보로 변경한다.
        for ( StuVO stu : stuVOList){
            if (stuVO.getStuNum() == stuVO.getStuNum()){
                stu.setStuNum(stuVO.getStuNum());
                stu.setStuName(stuVO.getStuName());
                stu.setKorScore(stuVO.getKorScore());
                stu.setEngScore(stuVO.getEngScore());
                stu.setStuIntroduce(stuVO.getStuIntroduce());
            }
        }


    }
}
