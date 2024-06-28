package com.green.DB_score.controller;

import com.green.DB_score.service.ScoreServiceImpl;
import com.green.DB_score.vo.ScoreVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ScoreController {
    @Resource(name = "scoreService")
    private ScoreServiceImpl scoreService;

    //학생 목록 페이지
    @GetMapping("/")
    public String stuList(Model model){
        //학생 목록 데이터를 db에서 조회
        List<ScoreVO> scoreVOList = scoreService.getStuList();
        model.addAttribute("scoreVOList", scoreVOList);
        for ( ScoreVO scoreVO : scoreVOList)
            System.out.println(scoreVO);
        return "stu_list";
    }

    //학생등록 페이지로 이동
    @GetMapping("/stuWriteForm")
    public String writeForm(){
        return "reg_student";
    }

    //학생등록 + 목록 페이지 이동
    @PostMapping("/regStudent")
    public String regStudent(ScoreVO scoreVO){
        scoreService.insert(scoreVO);
        return "redirect:/";
    }

    //학생 상세 정보 페이지
    @GetMapping("/stuDetail")
    public String stuDetail(@RequestParam(name = "stuNum") int stuNum, Model model){
        ScoreVO scoreVO = scoreService.getStuNum(stuNum);
        model.addAttribute("score", scoreVO);
        return "student_detail";
    }

    //정보 수정 페이지
    @GetMapping("/update")
    public String UpdateForm(@RequestParam(name = "stuNum") int stuNum , Model model){
        ScoreVO scoreVO = scoreService.getStuNum(stuNum);
        model.addAttribute("score", scoreVO);
        return "update_student";
    }

    //정보 수정 + 상세 페이지로 이동
    @PostMapping("updateStu")
    public String update(@RequestParam(name = "stuNum") int stuNum, ScoreVO scoreVO){
        ScoreVO vo = new ScoreVO();
        vo.setStuNum(stuNum);
        vo.setStuName(scoreVO.getStuName());
        vo.setKorScore(scoreVO.getKorScore());
        vo.setEngScore(scoreVO.getEngScore());
        vo.setIntro(scoreVO.getIntro());

        scoreService.setStuList(vo);
        return "redirect:/stuDetail?stuNum=" + vo.getStuNum();
    }

    //정보 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "stuNum") int stuNum){
        scoreService.delete(stuNum);
        return "redirect:/";
    }


}
