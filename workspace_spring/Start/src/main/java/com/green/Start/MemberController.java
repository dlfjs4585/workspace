package com.green.Start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

    //1. 자바에서 html로 데이터를 전달하기 위해서는
    //   실행되는 메서드의 매개변수의 Model 인터페이스 객체를 선언
    //2. 객체명.addAttribute메서드를 사용하여 데이터를 전달한다.
    @GetMapping("/m1")
    public String goMain(Model model){
        model.addAttribute("name","java");
        model.addAttribute("age",10);
        return "main";
    }

    @GetMapping("/l1")
    public String goLogin(Model model){
        String[] hobbies = {"독서","운동","공부"};
        model.addAttribute("abc",hobbies);
        Member member = new Member("홍",20,90);
        model.addAttribute("member", member);
        return "test_login";
    }

    @GetMapping("/j1")
    public String goJoin(Model model){
        List<Member> memberList = new ArrayList<>();
        Member member1 = new Member("kim",20,80);
        Member member2 = new Member("park",21,90);
        Member member3 = new Member("lee",22,85);

        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        model.addAttribute("memberList" , memberList);

        return "test_join";
    }


}


