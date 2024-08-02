package com.green.Shop.member.controller;


import com.green.Shop.member.service.MemberService;
import com.green.Shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api_member")
public class MemberController {
    @Resource(name = "memberService")
    private MemberService memberService;

    @PostMapping("/join")
    public void join(@RequestBody MemberVO memberVO){
        memberService.join(memberVO);
    }

    @GetMapping("/getId/{memId}")
    public boolean getId(@PathVariable("memId") String id){
        return memberService.getId(id);
    }
}
