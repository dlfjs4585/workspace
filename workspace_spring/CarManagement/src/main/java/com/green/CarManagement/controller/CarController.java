package com.green.CarManagement.controller;

import com.green.CarManagement.service.CarService;
import com.green.CarManagement.vo.CarVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carInfo")
public class CarController {
    @Resource(name = "carService")
    private CarService carService;

    // 차량 등록
    @PostMapping("/insert")
    public void insertCarInfo(@RequestBody CarVO carVO){
        carService.insertCarInfo(carVO);
    }

    // 차량 리스트 조회
    @GetMapping("/get")
    public List<CarVO> getCarList(){
        return carService.getCarList();
    }

    // 차량 이름 조회
    @GetMapping("/getCarNameList")
    public List<CarVO> getCarNameList(){
        return carService.getCarNameList();
    }


}
