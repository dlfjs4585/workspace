package com.green.Shop.member.controller;

import com.green.Shop.member.service.ShopMemberService;
import com.green.Shop.member.vo.ShopMemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class ShopMemberController {
    @Resource(name = "shopMemberService")
    private ShopMemberService shopMemberService;

    // 회원 가입
    @PostMapping("/insertMember")
    public void insertMember(@RequestBody ShopMemberVO shopMemberVO){
        shopMemberService.insertMember(shopMemberVO);
    }

    @GetMapping("/getId")
    public List<ShopMemberVO> getId(){
        return shopMemberService.getId();
    }
}
