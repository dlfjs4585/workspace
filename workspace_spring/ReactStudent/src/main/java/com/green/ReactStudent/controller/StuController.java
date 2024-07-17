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

    @GetMapping("/stuList")
    public List<StuVO> getStuList(){
        return stuService.getStuList();
    }

    @PostMapping("/insertStu")
    public void insertStu(@RequestBody StuVO stuVO){
        stuService.insertStu(stuVO);
    }

    @GetMapping("/getStuDetail/{stuNum}")
    public StuVO getStuDetail(@PathVariable("stuNum") int stuNum){
        return stuService.getStuDetail(stuNum);
    }

}
