package com.green.ReactStudent.controller;

import com.green.ReactStudent.service.StuService;
import com.green.ReactStudent.vo.StuVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StuController {
    @Resource(name = "stuService")
    private StuService stuService;

    // 학생 정보 조회
    @GetMapping("/stuList")
    public List<StuVO> getStuList(){
        return stuService.getStuList();
    }

    // 학생 정보 등록
    @PostMapping("/insertStu")
    public void insertStu(@RequestBody StuVO stuVO){
        stuService.insertStu(stuVO);
    }

    // 학생 상제 정보 조회
    @GetMapping("/getStuDetail/{stuNum}")
    public StuVO getStuDetail(@PathVariable("stuNum") int stuNum){
        return stuService.getStuDetail(stuNum);
    }

    // 학생 정보 삭제
    @DeleteMapping("/delStu/{stuNum}")
    public void delStu(@PathVariable("stuNum") int stuNum){
        stuService.delStu(stuNum);
    }

    // 학생 점수 등록
    @PutMapping("/updateScore")
    public void updateScore(@RequestBody StuVO stuVO){
        stuService.updateScore(stuVO);
    }

}
