package com.green.ListPractice.controllar;


import com.green.ListPractice.service.StudentService;
import com.green.ListPractice.vo.StuVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StuController {

    List<StuVO> stuVOList = new ArrayList<>();

    StudentService studentService = new StudentService();


    @GetMapping("/stuList")
    public String stuList(Model model){

        //학생 목록 데이터를 받아오기
        List<StuVO> stuVOList = studentService.getStuList();
        model.addAttribute("stuVOList", stuVOList);
        return "stu_list";
    }

    //학생 등록 페이지 이동
    @GetMapping("/stuWriteForm")
    public String writeForm(){
        return "reg_student";
    }

    //학생을 등록 + 목록 페이지 이동 메서드
    @PostMapping("/regStudent")
    public String regStudent(StuVO stuVO){

        studentService.regStudent(stuVO);

        System.out.println(stuVO);
        return "redirect:/stuList";
    }

    //학생명 클릭시 상세 페이지 이동
    @GetMapping("/stuDetail")
    public String stuDetail(@RequestParam(name = "stuNum") int stuNum, Model model){
        StuVO student = studentService.getStuDetail(stuNum);
        model.addAttribute("stu", student);

        return "student_detail";
    }

    //학생 삭제 + 목록 페이지 이동
    @GetMapping("/stuDelete")
    public String delete(@RequestParam(name = "stuNum") int stuNum){
        //학생 삭제
        studentService.deleteStu(stuNum);
        return "redirect:/stuList";
    }

    //학생 정보 수정 페이지
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "stuNum") int stuNum , Model model){

        //정보를 수정할 학생의 원래 정보를 html에 전달해야 함.
        //1. 정보를 수정할 학생 한명을 pick!!
        StuVO stuVO = studentService.getStuDetail(stuNum);
        //2. 학번 데이터를 이용하여 html로 데이터 전송
        model.addAttribute("stu",stuVO );
        return "update_student";
    }

    //학생 정보 수정 + 상세 페이지로 이동
    @PostMapping("/updateStu")
    public String updateStu(StuVO stuVO){
        studentService.updateStu(stuVO);
        return "redirect:/stuDetail?stuNum=" + stuVO.getStuNum();
    }


}
