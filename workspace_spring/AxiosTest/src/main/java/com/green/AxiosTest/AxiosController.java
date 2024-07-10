package com.green.AxiosTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//RestController : 컨트롤러 안의 메서드 리턴이 html 파일명이 아니다!
@RestController
public class AxiosController {

    @GetMapping("/test1")
    public String test1(){
        return "집에가고 싶다";
    }

    @GetMapping("/test2")
    public int test2(){
        return 100;
    }

    @GetMapping("/test3")
    public int[] test3(){
        int[] arr = {1,2,3,4,5};
        return arr;
    }

    @GetMapping("/test4")
    public List<ItemVO> test4(){
        List<ItemVO> itemList = new ArrayList<>();

        //ItemVO 객체를 세 개 리엑트로 전달
        ItemVO item1 = new ItemVO(1,"처음 만나는 자바",20000,"소개1", "book_1.jpg");
        ItemVO item2 = new ItemVO(2,"자바 디자인 패턴",25000,"소개2", "book_2.jpg");
        ItemVO item3 = new ItemVO(3,"모두의 딥러닝",30000,"소개3", "book_3.jpg");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        return itemList;
    }
}
