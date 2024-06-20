package com.green.DataPractice.controller;

import com.green.DataPractice.vo.DeliveryVO;
import com.green.DataPractice.vo.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    //주문정보 페이지
    @GetMapping("/order")
    public String order(){
        return "order";
    }
    //배달정보 페이지
    @PostMapping("/delivery")
    public String delivery(OrderVO orderVO){
        return "delivery";
    }
    //주문정보 확인 페이지
    @PostMapping("/orderInfo")
    public String orderInfo(OrderVO orderVO, DeliveryVO deliveryVO){
        return "order_info";
    }





}


