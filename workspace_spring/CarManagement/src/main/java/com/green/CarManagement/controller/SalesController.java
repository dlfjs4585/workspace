package com.green.CarManagement.controller;

import com.green.CarManagement.service.SalesService;
import com.green.CarManagement.vo.CarVO;
import com.green.CarManagement.vo.SalesVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Resource(name = "salesService")
    private SalesService salesService;


    @PostMapping("/insertSaleInfo")
    public void insertSaleInfo(@RequestBody SalesVO salesVO){
        salesService.insertSaleInfo(salesVO);
    }

    @GetMapping("/getCarList")
    public List<SalesVO> getCarList(){
        return salesService.getCarList();
    }

}
