package com.green.Shop.member.controller;


import com.green.Shop.member.service.MemberService;
import com.green.Shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api_member")
@Slf4j
public class MemberController {
    @Resource(name = "memberService")
    private MemberService memberService;

    // 회원가입
    @PostMapping("/join")
    public void join(@RequestBody MemberVO memberVO){
        memberService.join(memberVO);
    }

    // 아이디 중복 확인
    @GetMapping("/isEnableId/{memId}")
    public boolean getId(@PathVariable("memId") String memId){
        boolean result = memberService.isEnableId(memId);
        return result;
    }

    // 로그인 기능
    @PostMapping("/login")
    public MemberVO login(@RequestBody MemberVO memberVO){
        MemberVO member = memberService.login(memberVO);
        return member;
    }

}
