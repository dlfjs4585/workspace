package com.green.Board.controller;

import com.green.Board.service.MemberService;
import com.green.Board.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그 남길 때 쓰는 어노테이션, 모든 클래스 위에서 사용 가능
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name = "memberService")
    private MemberService memberService;

    @PostMapping("/insertMember")
    public void regMember(@RequestBody MemberVO memberVO){
        memberService.regMember(memberVO);
    }

    @GetMapping("/getId")
    public List<MemberVO> getMemId(){
        return memberService.getMemId();
    }

    @PostMapping("/login")
    public void login(@RequestBody MemberVO memberVO){
        memberService.login(memberVO);
    }
}
