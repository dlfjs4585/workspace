package com.green.DataPractice.controller;


import com.green.DataPractice.vo.ScoreVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScoreController {

    //시작페이지로 이동
    @GetMapping("/first")
    public String first(){
        return "score_first";
    }
    //첫번째 페이지에서 넘어온 데이터를 받아, 두번째 페이지로 이동
    @PostMapping("/second")
    public String second(ScoreVO scoreVO){
        System.out.println("이름 : " + scoreVO.getName());
        return "score_second";
    }
    //두번째 페이지에서 넘어온 데이터를 받아, 세번째 페이지로 이동
    @PostMapping("/third")
    public String third(ScoreVO scoreVO){
        System.out.println(scoreVO);
        return "score_third";
    }
    @PostMapping("/fourth")
    public String fourth(ScoreVO scoreVO, Model model){
        System.out.println(scoreVO);

        //자바에서 평균을 구해서 내보내는 방법
        double avg = (scoreVO.getKorScore() + scoreVO.getEngScore() + scoreVO.getMathScore()) / 3.0;
        model.addAttribute("avg", avg);
        return "score_fourth";
    }




}
