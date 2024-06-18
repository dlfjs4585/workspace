package com.green.Start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//이 클래스는 페이지(html) 이동을 담당 -> Controller
//@ : 어노테이션(Anotation)
@Controller //해당 클래스가 관제탑 역할을 하는 Controller 임을 안지시켜줌.
public class TestController {

    //컨트롤러 내의 리턴타입이 문자열(String)인 메서드는
    //실행하면 리턴되는 문자열 이름의 html파일을 실행
    @GetMapping("/t1")
    public String  goTest1(){
        System.out.println("goTest1 메서드 실행");
        return "test1";
    }
    @GetMapping("/t2")
    public String goTest2(){
        System.out.println("goTest2 메서드 실행");
        return "test2";
    }
    @GetMapping("/t3")
    public String goTest3(){
        System.out.println("goTest3 메서드 실행");
        return "test3";
    }

}
