package com.green.ReactGoods.controller;

import com.green.ReactGoods.service.GoodsService;
import com.green.ReactGoods.vo.GoodsVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Resource(name = "goodsService")
    private GoodsService goodsService;

    @GetMapping("/goodsInfo")
    public List<GoodsVO> getGoodsInfo(){
        return goodsService.getGoodsInfo();
    }

}
